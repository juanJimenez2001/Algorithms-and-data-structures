package aed.cache;

import es.upm.aedlib.Entry;
import es.upm.aedlib.Position;
import es.upm.aedlib.map.*;
import es.upm.aedlib.positionlist.*;


public class Cache<Key,Value> {


	// Tamano de la cache
	private int maxCacheSize;

	// NO MODIFICA ESTOS ATTRIBUTOS, NI CAMBIA SUS NOMBRES: mainMemory, cacheContents, keyListLRU

	// Para acceder a la memoria M
	private Storage<Key,Value> mainMemory;
	// Un 'map' que asocia una clave con un ``CacheCell''
	private Map<Key,CacheCell<Key,Value>> cacheContents;
	// Una PositionList que guarda las claves en orden de
	// uso -- la clave mas recientemente usado sera el keyListLRU.first()
	private PositionList<Key> keyListLRU;



	// Constructor de la cache. Especifica el tamano maximo 
	// y la memoria que se va a utilizar
	public Cache(int maxCacheSize, Storage<Key,Value> mainMemory) {
		this.maxCacheSize = maxCacheSize;

		// NO CAMBIA
		this.mainMemory = mainMemory;
		this.cacheContents = new HashTableMap<Key,CacheCell<Key,Value>>();
		this.keyListLRU = new NodePositionList<Key>();
	}



	// Devuelve el valor que corresponde a una clave "Key"
	public Value get(Key key) {
		Value res = null;
		if(cacheContents.containsKey(key)) {
			CacheCell<Key,Value> llave = cacheContents.get(key);
			res = llave.getValue();
			keyListLRU.remove(llave.getPos());
			keyListLRU.addFirst(key);
			llave.setPos(keyListLRU.first());
		}
		else {
			if(mainMemory.read(key)==null)
				return null;
			keyListLRU.addFirst(key);		  
			CacheCell<Key,Value> llave = new CacheCell<Key,Value>(mainMemory.read(key),false,keyListLRU.first());		
			if(cacheContents.size() < maxCacheSize) {
				cacheContents.put(key, llave);
				res = llave.getValue();
			}
			else {
				Key ultimoKey = keyListLRU.last().element();
				if(cacheContents.get(ultimoKey).getDirty())			
					mainMemory.write(ultimoKey, cacheContents.get(ultimoKey).getValue());
				cacheContents.remove(ultimoKey);
				keyListLRU.remove(keyListLRU.last());
				cacheContents.put(key, llave);
				res = llave.getValue();
			}
		}
		return res;
	}




	// Establece un valor nuevo para la clave en la memoria cache
	public void put(Key key, Value value) {
		if(cacheContents.containsKey(key)) {
			keyListLRU.remove(cacheContents.get(key).getPos());
			keyListLRU.addFirst(key);
			cacheContents.get(key).setValue(value);
			cacheContents.get(key).setDirty(true);
			cacheContents.get(key).setPos(keyListLRU.first());
		}
		else {
			keyListLRU.addFirst(key);		  
			CacheCell<Key,Value> llave = new CacheCell<Key,Value>(value,true,keyListLRU.first());		
			if(cacheContents.size() < maxCacheSize) {
				cacheContents.put(key, llave);
			}
			else {
				Key ultimoKey = keyListLRU.last().element();
				if(cacheContents.get(ultimoKey).getDirty())			
					mainMemory.write(ultimoKey, cacheContents.get(ultimoKey).getValue());
				cacheContents.remove(ultimoKey);
				keyListLRU.remove(keyListLRU.last());
				cacheContents.put(key, llave);
			}
		}
	}




	// NO CAMBIA
	public String toString() {
		return "cache";
	}
}


