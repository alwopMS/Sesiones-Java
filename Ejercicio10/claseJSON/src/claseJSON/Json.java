package claseJSON;

import org.json.JSONArray;
import org.json.JSONObject;

public class Json {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject nuevo = new JSONObject();
		nuevo.putOnce("alumno", "Juan");
		nuevo.put("Edad", 24);
		nuevo.put("Estado", "Dormido");
		
		JSONObject fra = new JSONObject();
		fra.put("nombre", "jajajajaja");
		fra.put("Dos", "frfrfr");
		
		JSONArray papa = fra.toJSONArray(fra.names());
		System.out.println(papa);
		JSONArray array = new JSONArray();
		array.put(0, nuevo);
		array.put(1,true);
		System.out.println(array);
		
		
	}

}
