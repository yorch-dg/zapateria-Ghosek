// JavaScript Document
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Zapateria {
    public static void main(String[] args) {
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get("zapateria.json")));
            JSONArray productos = new JSONArray(content);
            mostrarProductos(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarProductos(JSONArray productos) {
        System.out.println("Folio | Descripción                  | Talla | Precio");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < productos.length(); i++) {
            JSONObject producto = productos.getJSONObject(i);
            System.out.printf("%-6d | %-28s | %-5s | $%d%n",
                    producto.getInt("folio"),
                    producto.getString("descripcion"),
                    producto.getString("talla"),
                    producto.getInt("precio"));
        }
    }
}
