package mx.itson.edu.practica3

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {

    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var listview: ListView = findViewById<ListView>(R.id.listview)
        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador

    }

    fun agregarProductos(option:String?) {
        var title: ImageView = findViewById<ImageView>(R.id.imageView)
        when(option) {
            "Antojitos" -> {
                title.setImageResource(R.drawable.antojitos)
                menu.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con su carne favorita, servidas con ensalada", 6.29))
                menu.add(Product("Gringas", R.drawable.gringas, "Tortilla de harina con queso, carne al pastor y piña", 8.39))
                menu.add(Product("Sopes", R.drawable.sopes, "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema", 3.99))
                menu.add(Product("Sincronizada", R.drawable.sincronizadas, "Tortilla de harina rellena con queso y jamón. Acompañada de lechuga, crema y guacamole.", 7.99))
                menu.add(Product("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema", 11.49))
                menu.add(Product("Tostadas", R.drawable.tostadas, "Tortilla  frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate.", 4.59))
            }
            "Especialidades" -> {
                title.setImageResource(R.drawable.especialidades)
                menu.add(Product("Mojarra Frita", R.drawable.mojarra, "Tilapia frita servida con lechuga, cebolla, jitomate, aguacate y tortillas.", 17.99))
                menu.add(Product("Ceviche", R.drawable.ceviche, "Tilapia, camarones, aguacate y pico de gallo servido con chips", 6.99))
                menu.add(Product("Botana de Camarones",R.drawable.botanacamarones, "", 19.99))
            }
            "Combinations" -> {
                title.setImageResource(R.drawable.combinations)
                menu.add(Product("Taco Combo Tradicional", R.drawable.combinationtaco, "Tortilla de maíz y tu carne favorita. Servido con arroz y frijoles", 6.99))
                menu.add(Product("Mexican Burritos", R.drawable.burritos, "Tu carne favorita en una tortilla grande de harina rellena con cebolla frita, pico de gallo, sour crea, frijoles y acompañado de arroz", 13.69))
                menu.add(Product("Los Portales Burrito", R.drawable.burritosportales, "Tortilla grande de harina rellena de nopal asado, bistec, pastor, cebolla asada, arroz y frijoles. Servida con ensalada de lechuga, tomate, crema agria y guacamole.", 14.59))
                menu.add(Product("Cinco", R.drawable.cinco, "Un taco de venta fuerte con su elección de carne, lechuga y queso. Un burrito con su elección de carne, pico de gallo, crema agria y frijoles. Servido con arroz y frijoles.", 10.99))
                menu.add(Product("Burrito", R.drawable.burritopepe, "Tortilla de harina rellena de la carne de su elección con frijoles, lechuga, crema agria, guacamole y pico de gallo. Servida con arroz.", 10.99))
                menu.add(Product("Fajita Quesadilla", R.drawable.fajitaquesadilla, "Quesadilla extra grande (10 inches), rellena con tu carne favorita, cebolla asada, chile morrón. Servida con arroz, frijoles, lechuga, crema y pico de gallo.", 14.59))
            }
            "Tortas" -> {
                title.setImageResource(R.drawable.tortas)
                menu.add(
                    Product(
                        "Torta Regular",
                        R.drawable.torta,
                        "Todas las tortas vienen con lechuga, cebolla, tomate, aguacate, crema agria, chile jalapeño y la carne de su elección.",
                        13.39
                    )
                )
                menu.add(
                    Product(
                        "Torta Milanesa de Pollo",
                        R.drawable.tortamilanesa,
                        "Pollo",
                        13.99
                    )
                )
                menu.add(
                    Product(
                        "Torta Cubana",
                        R.drawable.tortacubana,
                        "Chorizo, asada, jamon, pastor y queso",
                        14.49
                    )
                )
                menu.add(
                    Product(
                        "Torta Mixta",
                        R.drawable.tortamixta,
                        "Chorizo, asada y pastor.",
                        13.99
                    )
                )
                menu.add(Product("Small Mexican Torta", R.drawable.smallmexican, "Sándwich de pan bollio con tu carne favorita, lechuga rallada, aguacate, tomate, cebolla y crema.", 11.99))
            }
            "Sopas" -> {
                title.setImageResource(R.drawable.sopas)
                menu.add(
                    Product(
                        "Caldo de Res",
                        R.drawable.caldores,
                        "Costillas de res y estofado de carne con maíz, papa, chayote, repollo, cilantro, cebolla, calabacín, zanahoria, limón y tortillas. ¡NO OLVIDES NUESTRA BARRA DE SALSAS PARA AÑADIRLE MÁS SABOR!",
                        8.39
                    )
                )
                menu.add(
                    Product(
                        "Pozole",
                        R.drawable.pozole,
                        "Costillas de cerdo y estofado de ternera con maíz y orégano. ¡NO OLVIDES NUESTRA BARRA DE SALSAS PARA AÑADIRLE MÁS SABOR!",
                        7.99
                    )
                )
                menu.add(
                    Product(
                        "Menudo",
                        R.drawable.menudo,
                        "Caldo ancestral, callos sedosos se unen en un plato que sabe a mañanas de domingo, cocinas familiares e historias transmitidas de generación en generación.",
                        13.99
                    )
                )
                menu.add(
                    Product(
                        "Caldo de Camaron",
                        R.drawable.caldocamaron,
                        "Caldo de Camarón",
                        13.99
                    )
                )
                menu.add(
                    Product(
                        "Sopa de Mariscos",
                        R.drawable.sopamariscos,
                        "Sopa de mariscos",
                        21.99
                    )
                )
            }
            "Drinks" -> {
                title.setImageResource(R.drawable.drinks)
                menu.add(Product("Sodas 20 oz", R.drawable.sodas, "Sodas 20 oz", 2.99))
                menu.add(Product("Jarritos", R.drawable.jarritos, "", 2.75))
                menu.add(Product("Caguama", R.drawable.caguama, "", 9.99))
                menu.add(Product("Caguama Michelada", R.drawable.caguamamichelada, "", 14.99))
            }
        }
    }

    private class AdaptadorProductos: BaseAdapter {
        var producto = ArrayList<Product>()
        var contexto: Context?=null

        constructor(contexto: Context, producto: ArrayList<Product>){
            this.producto = producto
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return producto.size
        }

        override fun getItem(position: Int): Any? {
            return producto[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View {
            var prod= producto[position]
            var inflador = LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}