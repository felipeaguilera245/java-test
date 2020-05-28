package models;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Pharma {

	public JSONObject getList(String comune_id, String pharma_name) {

		JSONObject object = new JSONObject();
		JSONArray results = null;

		object.put("results", results);

		String url = "https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion?id_region=7";

		try {

			String json = Jsoup.connect(url).ignoreContentType(true).execute().body();

			results = new JSONArray(json);

			if (!"-1".equals(comune_id)) {

				results = returnSearch(results, comune_id, "fk_comuna");

			}

			if (!"-1".equals(pharma_name)) {

				results = returnSearch(results, pharma_name, "local_nombre");

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

		object.put("pharma_results", results);

		return object;

	}

	public JSONArray returnSearch(JSONArray array, String searchValue, String search_key) {

		JSONArray filtedArray = new JSONArray();

		for (int i = 0; i < array.length(); i++) {

			JSONObject obj = null;

			try {

				obj = array.getJSONObject(i);

				if (obj.getString(search_key).equals(searchValue)) {

					filtedArray.put(obj);

				}

			} catch (JSONException e) {

				e.printStackTrace();

			}

		}

		return filtedArray;
	}

	public JSONObject getComunes() {

		JSONObject object = new JSONObject();

		String url = "https://midastest.minsal.cl/farmacias/maps/index.php/utilidades/maps_obtener_comunas_por_regiones";

		Document doc = null;

		try {

			doc = Jsoup.connect(url).timeout(0).data("reg_id", "7").post();

			object.put("options", doc.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return object;

	}

	public JSONObject getPharmaNames() {

		JSONObject object = new JSONObject();

		JSONArray results = null;

		String response = "";

		object.put("results", results);

		String url = "https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion?id_region=7";

		try {

			String json = Jsoup.connect(url).ignoreContentType(true).execute().body();

			results = new JSONArray(json);

			response = clearData(results);

		} catch (IOException e) {

			e.printStackTrace();

		}

		object.put("pharma_options", response);

		return object;

	}

	public String clearData(JSONArray array) {

		String response = "";

		HashMap<String, String> pharmas = new HashMap<String, String>();

		for (int i = 0; i < array.length(); i++) {

			JSONObject obj = null;

			try {

				obj = array.getJSONObject(i);

				if (!pharmas.containsKey(obj.getString("local_nombre").replaceAll(" ", ""))) {

					pharmas.put(obj.getString("local_nombre").replaceAll(" ", ""), obj.getString("local_nombre"));

					response = response + "<option value=" + obj.getString("local_nombre").replaceAll(" ", "") + ">"
							+ obj.getString("local_nombre") + "</option>";

				}

			} catch (JSONException e) {

				e.printStackTrace();

			}

		}

		return response;
	}

}
