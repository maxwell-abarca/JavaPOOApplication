package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Provincias {
    ArrayList<ObservableList<String>> itemsCantones = new ArrayList<>();
    ArrayList<ObservableList<String>> itemsDistritos = new ArrayList<>();


    ObservableList<String> provincias = FXCollections.observableArrayList(
            "Alajuela",
            "Cartago",
            "Guanacaste",
            "Heredia",
            "Limon",
            "Puntarenas",
            "San José"
    );
    ObservableList<String> cantonesDeAlajuela = FXCollections.observableArrayList(
            "Atenas",
            "Grecia",
            "Guatuso",
            "Los Chiles",
            "Naranjo",
            "Orotina",
            "Palmares",
            "Poás",
            "San Carlos",
            "San Mateo",
            "San Ramón",
            "Upala"

    );
    ObservableList<String> cantonesDeCartago = FXCollections.observableArrayList(
            "Alvarado",
            "Cartago Central",
            "El Guarco",
            "Jiménez",
            "La Unión",
            "Oreamuno",
            "Paraíso",
            "Turrialba"

    );
    ObservableList<String> cantonesDeGuanacaste = FXCollections.observableArrayList(
            "Abangares",
            "Bagaces",
            "Cañas",
            "Carrillo",
            "Nicoya",
            "Hojancha",
            "La Cruz",
            "Liberia",
            "Nandayure",
            "Santa Crúz",
            "Tilarán"
    );
    ObservableList<String> cantonesDeHeredia = FXCollections.observableArrayList(
            "Barva",
            "Belén",
            "Flores",
            "Heredia Central",
            "San Isidro",
            "San Pablo",
            "San Rafael",
            "Santa Bárbara",
            "Santo Domingo",
            "Sarapiquí"
    );
    ObservableList<String> cantonesDeLimon = FXCollections.observableArrayList(
            "Guácimo",
            "Limón",
            "Matina",
            "Pococí",
            "Siquirres",
            "Talamanca"
    );
    ObservableList<String> cantonesDePuntarenas = FXCollections.observableArrayList(
            "Buenos Aires",
            "Corredores",
            "Coto Brus",
            "Esparza",
            "Garabito",
            "Golfito",
            "Montes de Oro",
            "Osa",
            "Parrita",
            "Puntarenas Central",
            "Quepos"
    );
    ObservableList<String> cantonesDeSanJose = FXCollections.observableArrayList(
            "Acosta",
            "Alajuelita",
            "Aserrí",
            "Curridabat",
            "Desamparados",
            "Dota",
            "Escazú",
            "Goicoechea",
            "León Cortés Castro",
            "Montes de Oca",
            "Mora",
            "Moravia",
            "Puriscal",
            "San José Central",
            "Tarrazú",
            "Tibás",
            "Turrubares",
            "Vázquez de Coronado"

    );

    ObservableList<String> distritosDeAtenas = FXCollections.observableArrayList(
            "Atenas",
            "Jesús",
            "Mercedes",
            "San Isidro",
            "Concepción",
            "San José",
            "Santa Eulalia",
            "Escobal"
    );
    ObservableList<String> distritosDeGrecia = FXCollections.observableArrayList(
            "San Isidro",
            "San Roque",
            "Tacares",
            "Río Cuarto",
            "Puente de Piedra",
            "San José",
            "Bolívar Ángeles"

    );
    ObservableList<String> distritosDeGuatuso = FXCollections.observableArrayList(
            "San Rafael",
            "Buenavista",
            "Cote"
    );
    ObservableList<String> distritosDeLosChiles = FXCollections.observableArrayList(
            "Los Chiles",
            "Caño Negro",
            "El Amparo",
            "San Jorge"
    );
    ObservableList<String> distritosDeNaranjo = FXCollections.observableArrayList(
            "Naranjo",
            "San Miguel",
            "San José",
            "Cirrí Sur",
            "San Jerónimo",
            "San Juan",
            "Rosario",
            "San Jorge"
    );
    ObservableList<String> distritosDeOrotina = FXCollections.observableArrayList(
            "Orotina",
            "Mastate",
            "Hacienda",
            "Coyolar",
            "Ceiba"
    );
    ObservableList<String> distritosDePalmares = FXCollections.observableArrayList(
            "Palmares",
            "Zaragoza",
            "Buenos Aires",
            "Santiago",
            "Candelaria",
            "Esquipulas",
            "La Granja"
    );
    ObservableList<String> distritoDePoas = FXCollections.observableArrayList(
            "San Pedro",
            "San Juan",
            "San Rafael",
            "Carrillos",
            "Sabana Redonda"
    );
    ObservableList<String> distritosDeSanCarlos = FXCollections.observableArrayList(
            "Quesada",
            "Florencia",
            "Buenavista",
            "Aguas Zarcas",
            "Venecia",
            "Pital",
            "Fortuna",
            "Tigra",
            "Palmera",
            "Venado",
            "Cutris",
            "Santo Domingo",
            "Pocosol",
            "Santa Rosa"
    );
    ObservableList<String> distritosDeSanMateo = FXCollections.observableArrayList(
            "San Mateo",
            "Desmonte",
            "Jesús María"
    );
    ObservableList<String> distritosDeSanRamon = FXCollections.observableArrayList(
            "San Ramón",
            "Santiago",
            "San Juan",
            "Piedades Norte",
            "Piedades Sur",
            "San Rafael",
            "San Isidro",
            "Ángeles",
            "Alfaro",
            "Volio",
            "Concepción",
            "Zapotal",
            "Peñas Blancas"
    );
    ObservableList<String> distritosDeUpala = FXCollections.observableArrayList(
            "Upala",
            "Aguas Claras",
            "San José(Pizote)",
            "Bijagua",
            "Delicias",
            "Dos Ríos",
            "Yolillal",
            "San Isidro de Zapote"
    );
    ObservableList<String> distritosDeAlvarado = FXCollections.observableArrayList(
            "Pacayas",
            "Cervantes",
            "Capellades"
    );
    ObservableList<String> distritosDeCartagoCentral = FXCollections.observableArrayList(
            "Ciudad de Cartago sur",
            "Ciudad de Cartago Norte",
            "El Carmen",
            "San Nicolás Taras",
            "San Francisco(Aguas Calientes)",
            "Guadalupe(Arenilla)",
            "Corralillo",
            "Tierra Blanca",
            "Dulce Nombre",
            "Llano Grande",
            "Quebradilla"
    );
    ObservableList<String> distritosDeElGuarco = FXCollections.observableArrayList(
            "El Tejar",
            "San Isidro",
            "Tobosi",
            "Patio de Aqua"
    );
    ObservableList<String> distritosDeJimenez = FXCollections.observableArrayList(
            "Juan Viñas",
            "Tucurrique",
            "Pejibaye"
    );
    ObservableList<String> distritosDeLaUnion = FXCollections.observableArrayList(
            "Tres Ríos",
            "San Diego",
            "San Juan",
            "San Rafael",
            "Concepcíon",
            "Dulce Nombre",
            "San Ramón",
            "Río Azul"
    );
    ObservableList<String> distritosDeOreamuno = FXCollections.observableArrayList(
            "San Rafael",
            "Cuna",
            "Potrero Cerrado",
            "Cipresses",
            "Santa Rosa"
    );
    ObservableList<String> distritosDeParaiso = FXCollections.observableArrayList(
            "Paraíso",
            "Santiago",
            "Orosi",
            "Cachí"
    );
    ObservableList<String> distritosDeTurrialba = FXCollections.observableArrayList(
            "Turrialba",
            "La Suiza",
            "Peralta",
            "Santa Cruz",
            "Santa Terisita",
            "Tuis",
            "Tayucit",
            "Santa Rosa",
            "Pavones",
            "Tres Equis"
    );
    ObservableList<String> distritosDeAbangares = FXCollections.observableArrayList(
            "Las Juntas",
            "La Sierra",
            "San Juan",
            "Colorado"
    );
    ObservableList<String> distritosDeBagaces = FXCollections.observableArrayList(
            "Bagaces",
            "Fortuna",
            "Mogote",
            "Río Naranjo"
    );
    ObservableList<String> distritosDeCanas = FXCollections.observableArrayList(
            "Ciudad de Cañas",
            "Palmira",
            "San Miguel",
            "Bebedero",
            "Porozal"
    );
    ObservableList<String> distritosDeCarrillos = FXCollections.observableArrayList(
            "Filadefia",
            "Palmira",
            "Sardinal",
            "Belán"
    );
    ObservableList<String> distritosDeNicoya = FXCollections.observableArrayList(
            "Ciudad de Liberia",
            "Mansión",
            "San Antonio",
            "Quebrada Honda",
            "Sámara",
            "Nosara",
            "Belén de Nosarita"
    );
    ObservableList<String> distritosDeHojancha = FXCollections.observableArrayList(
            "Ciudad de Hojancha",
            "Monteroma",
            "Puerto Carrillo",
            "Huacas"
    );
    ObservableList<String> distritosDeLaCruz = FXCollections.observableArrayList(
            "Ciudad de La Cruz",
            "Santa Cecilia",
            "La Garita",
            "Santa Elena"
    );
    ObservableList<String> distritosDeLiberia = FXCollections.observableArrayList(
            "Ciudad de Liberia",
            "Cañas Dulces",
            "Mayorga",
            "Nacascolo",
            "Curubandé"
    );
    ObservableList<String> distritosDeNandayure = FXCollections.observableArrayList(
            "Ciudad de Carmona",
            "Santa Rita",
            "Zapotal",
            "San Pablo",
            "Porvenir",
            "Bejuco"
    );
    ObservableList<String> distritosDeSantaCruz = FXCollections.observableArrayList(
            "Ciudad de Santa Cruz",
            "Bolsón",
            "Veitisiete de Abril",
            "Tempate",
            "Cartagena",
            "Cuajiniquil",
            "Diriá",
            "Cabo Velas",
            "Tamarindo"
    );
    ObservableList<String> distritosDeTilaran = FXCollections.observableArrayList(
            "Ciudad de Tilarán",
            "Quebrada Grande",
            "Tronadora",
            "Santa Rosa",
            "Líbano",
            "Tierras Morenas",
            "Arenal"
    );
    ObservableList<String> distritosDeBarva = FXCollections.observableArrayList(
            "Barva",
            "San Pedro",
            "San Pablo",
            "San Roque",
            "Santa Lucía",
            "San José de la Montaña"
    );
    ObservableList<String> distritosDeBelen = FXCollections.observableArrayList(
            "Ciudad de San Antonio",
            "Ribera",
            "Asunción"
    );
    ObservableList<String> distritosDeFlores = FXCollections.observableArrayList(
            "Ciudad de San Joaquín",
            "Barrantes",
            "Llorrente"
    );
    ObservableList<String> distritosDeHerediaCentral = FXCollections.observableArrayList(
            "Ciudad de Heredia",
            "Mercedes (Mercedes Norte)",
            "San Francisco",
            "Ulloa (Barrial)",
            "Vara Blanca"
    );
    ObservableList<String> distritosDeSanIsidro = FXCollections.observableArrayList(
            "Ciudad de San Isidro",
            "San José",
            "Concepción"
    );
    ObservableList<String> distritosDeSanPablo = FXCollections.observableArrayList(
            "Ciudad de San Pablo"
    );
    ObservableList<String> distritosDeSanRafael = FXCollections.observableArrayList(
            "Ciudad de San Rafael",
            "San Josecito",
            "Santiago",
            "Ángeles",
            "Concepción"
    );
    ObservableList<String> distritosDeSantaBarbara = FXCollections.observableArrayList(
            "Ciudad de Santa Bárbara",
            "San Pedro",
            "San Juan",
            "Jesús",
            "Santo Domingo",
            "Purabá, Zentillal"
    );
    ObservableList<String> distritosDeSantoDomingo = FXCollections.observableArrayList(
            "Ciudad de Santo Domingo",
            "San Vicente",
            "San Miguel Sur",
            "Paracito",
            "Santo Tomás",
            "Santa Rosa",
            "Tures",
            "Pará"
    );
    ObservableList<String> distritosDeSarapiqui = FXCollections.observableArrayList(
            "Puerto Viejo",
            "La Virgen",
            "Horquetas (Buenos Aires)",
            "Río Frío",
            "Cureña"
    );
    ObservableList<String> distritosDeGuacimo = FXCollections.observableArrayList(
            "Ciudad Guácimo",
            "Mercedes",
            "Pocora",
            "Río Jiménez",
            "Duacarí"
    );
    ObservableList<String> distritosDeLimonCentral = FXCollections.observableArrayList(
            "Ciudad de Limón",
            "Valle La Estrella",
            "Río Blanco",
            "Matama"
    );
    ObservableList<String> distritosDeMatina = FXCollections.observableArrayList(
            "Ciudad Matina",
            "Batán",
            "Carrandi"
    );
    ObservableList<String> distritosDePococi = FXCollections.observableArrayList(
            "Ciudad de Guápiles",
            "Jiménez",
            "La Rita",
            "Roxana",
            "Cariari",
            "Cariari"
    );
    ObservableList<String> distritosDeSiquirres = FXCollections.observableArrayList(
            "Ciudad de Siquirres",
            "Pacuarito",
            "Florida",
            "Germania",
            "El Cairo",
            "La Alegría"
    );
    ObservableList<String> distritosDeTalamanca = FXCollections.observableArrayList(
            "Bri Bri",
            "Sixaola",
            "Cahuita"
    );
    ObservableList<String> distritosDeBuenosAires = FXCollections.observableArrayList(
            "Buenos Aires",
            "Volcán",
            "Potrero Grande",
            "Boruca",
            "Pilas",
            "Manazanillo",
            "Colinas",
            "Chánguena",
            "Biolley",
            "Isla del Coco",
            "Cóbano",
            "Chacarita"
    );
    ObservableList<String> distritosDeCorredores = FXCollections.observableArrayList(
            "Ciudad de Corredores",
            "La Cuesta",
            "Paso Canoas",
            "Laurel"
    );
    ObservableList<String> distritosDeCotoBrus = FXCollections.observableArrayList(
            "Ciudad de San Vito",
            "Sabalito",
            "Agua Buena",
            "Limoncito",
            "Pittier"
    );
    ObservableList<String> distritosDeEsparza = FXCollections.observableArrayList(
            "Ciudad de Espíritu Santo",
            "San Juan Grande",
            "Macacona",
            "San Rafaél",
            "San Jerónimo"
    );
    ObservableList<String> distritosDeGarabito = FXCollections.observableArrayList(
            "Ciudad de Jacó",
            "Tárcoles"
    );
    ObservableList<String> distritosDeGolfito = FXCollections.observableArrayList(
            "Ciudad de Golfito",
            "Puerto Jiménez",
            "Guaycará, Río Claro",
            "Pavón"
    );
    ObservableList<String> distritosDeMontesDeOro = FXCollections.observableArrayList(
            "Ciudad Mirimar",
            "La Unión",
            "San Isidro"
    );
    ObservableList<String> distritosDeOsa = FXCollections.observableArrayList(
            "Ciudad de Puerto Cortés",
            "Palmar, Palmar Norte",
            "Sierpe",
            "Bahía Ballena",
            "Piedras Blancas"
    );
    ObservableList<String> distritosDeParrita = FXCollections.observableArrayList(
            "Ciudad Parrita"
    );
    ObservableList<String> distritosDePuntarenasCentral = FXCollections.observableArrayList(
            "Ciudad de Puntarenas",
            "Pitahaya",
            "Chomes",
            "Lepanto",
            "Paquera",
            "Manazanillo",
            "Guacimal",
            "Barranca",
            "Monte Verde, Santa Elena",
            "Isla del Coco",
            "Cóbano",
            "Chacarita"
    );
    ObservableList<String> distritosDeQuepos = FXCollections.observableArrayList(
            "Ciudad de Quepos",
            "Savegre Matapalo",
            "Naranjito"
    );
    ObservableList<String> distritosDeAcosta = FXCollections.observableArrayList(
            "Ciudad de San Ignacio",
            "Guatil",
            "Palmichal",
            "Cangrejal",
            "Sabanillas"
    );
    ObservableList<String> distritosDeAlajuelita = FXCollections.observableArrayList(
            "Ciudad de Alajuelita",
            "San Josecito",
            "San Antonio",
            "Concepción",
            "San Felipe"
    );
    ObservableList<String> distritosDeAserri = FXCollections.observableArrayList(
            "Ciudad Aserrí",
            "Tarbaca(Praga)",
            "Vuelta de Jorco",
            "San Gabriel",
            "La Legua",
            "Monterrey",
            "Salitrillos"
    );
    ObservableList<String> distritosDeCurridabat = FXCollections.observableArrayList(
            "Ciudad Curridabat",
            "Granadilla",
            "Sánchez",
            "Tirrases"
    );
    ObservableList<String> distritosDeDesamparados = FXCollections.observableArrayList(
            "Ciudad Desamparados",
            "San Miguel",
            "San Juan de Dios",
            "San Rafael Arriba",
            "San Antonio",
            "Frailes",
            "Patarrá",
            "Ciudad de Liberia",
            "San Crisóbal, San Cristóbal Norte",
            "Rosario",
            "Damas, Fátima",
            "San Rafael Abajo",
            "Gravilias"
    );
    ObservableList<String> distritosDeDota = FXCollections.observableArrayList(
            "Pueblo de Santa María",
            "El Jardín",
            "Copey"
    );
    ObservableList<String> distritosDeEscazu = FXCollections.observableArrayList(
            "Ciudad de Escazú",
            "San Antonio",
            "San Rafael"
    );
    ObservableList<String> distritosDeGoicoechea = FXCollections.observableArrayList(
            "Ciudad de Guadalupe",
            "San Francisco",
            "Calle Blancos",
            "Mata de Plátano",
            "Ipís",
            "Rancho Redondo",
            "Purral"
    );
    ObservableList<String> distritosDeLeonCortesCastro = FXCollections.observableArrayList(
            "Ciudad de San Pablo",
            "San Andrés",
            "Llano Bonito",
            "San Isidro",
            "Santa Cruz",
            "San Antonio"
    );
    ObservableList<String> distritosDeMontesDeOca = FXCollections.observableArrayList(
            "Ciudad de San Pedro",
            "Sabanilla",
            "Mercedes (Betania)",
            "San Rafael"
    );
    ObservableList<String> distritosDeMora = FXCollections.observableArrayList(
            "Ciudad de Colón",
            "Guyabo",
            "Tabarcia",
            "Piedras Negras",
            "Picagres"
    );
    ObservableList<String> distritosDeMoravia = FXCollections.observableArrayList(
            "Ciudad de San Vicente",
            "San Jerónimo",
            "Trinidad"
    );
    ObservableList<String> distritoaDePuriscal = FXCollections.observableArrayList(
            "Ciudad de Santiago",
            "Mercedes Sur",
            "Barbacoas",
            "Grifo Alto",
            "San Rafael",
            "Candelaria",
            "Desamparaditos",
            "San Antonio",
            "Chires"

    );
    ObservableList<String> distritosDeSanJoseCentral = FXCollections.observableArrayList(
            "Carmen",
            "Merced",
            "Hospital",
            "Catedral",
            "Zapote",
            "San Francisco de Dos Ríos",
            "Uruca",
            "Mata Redonda, Morenos",
            "Pavas",
            "Hatillo",
            "San Sebastián"
    );
    ObservableList<String> distritosDeTarrazu = FXCollections.observableArrayList(
            "Ciudad de San Marcos",
            "San Lorenzo",
            "San Carlos"
    );
    ObservableList<String> distritosDeTibas = FXCollections.observableArrayList(
            "Ciudad de San Juan",
            "Cinco Esquinas",
            "Anselmo Llorente",
            "León 13"
    );
    ObservableList<String> distritosDeTurrubares = FXCollections.observableArrayList(
            "San Pablo",
            "San Pedro",
            "San Juan de Mata",
            "San Luis"
    );
    ObservableList<String> distritosDeVasquezDeCoronado = FXCollections.observableArrayList(
            "Ciudad de San Isidro",
            "San Rafael",
            "Jesús (Dulce Nombre)",
            "Patalillo",
            "Cascajal"
    );


    public Provincias() {
        itemsCantones.add(cantonesDeAlajuela);
        itemsCantones.add(cantonesDeCartago);
        itemsCantones.add(cantonesDeGuanacaste);
        itemsCantones.add(cantonesDeHeredia);
        itemsCantones.add(cantonesDeLimon);
        itemsCantones.add(cantonesDePuntarenas);
        itemsCantones.add(cantonesDeSanJose);

        itemsDistritos.add(distritosDeAtenas);
        itemsDistritos.add(distritoDePoas);
        itemsDistritos.add(distritosDeGrecia);
        itemsDistritos.add(distritosDeGuatuso);
        itemsDistritos.add(distritosDeLosChiles);
        itemsDistritos.add(distritosDeNaranjo);
        itemsDistritos.add(distritosDeOrotina);
        itemsDistritos.add(distritosDePalmares);
        itemsDistritos.add(distritosDeSanCarlos);
        itemsDistritos.add(distritosDeSanMateo);
        itemsDistritos.add(distritosDeSanRamon);
        itemsDistritos.add(distritosDeUpala);
        itemsDistritos.add(distritosDeAlvarado);
        itemsDistritos.add(distritosDeCartagoCentral);
        itemsDistritos.add(distritosDeElGuarco);
        itemsDistritos.add(distritosDeJimenez);
        itemsDistritos.add(distritosDeLaUnion);
        itemsDistritos.add(distritosDeOreamuno);
        itemsDistritos.add(distritosDeParaiso);
        itemsDistritos.add(distritosDeTurrialba);
        itemsDistritos.add(distritosDeAbangares);
        itemsDistritos.add(distritosDeBagaces);
        itemsDistritos.add(distritosDeCanas);
        itemsDistritos.add(distritosDeCarrillos);
        itemsDistritos.add(distritosDeNicoya);
        itemsDistritos.add(distritosDeHojancha);
        itemsDistritos.add(distritosDeLaCruz);
        itemsDistritos.add(distritosDeLiberia);
        itemsDistritos.add(distritosDeNandayure);
        itemsDistritos.add(distritosDeSantaCruz);
        itemsDistritos.add(distritosDeTilaran);
        itemsDistritos.add(distritosDeBarva);
        itemsDistritos.add(distritosDeBelen);
        itemsDistritos.add(distritosDeFlores);
        itemsDistritos.add(distritosDeHerediaCentral);
        itemsDistritos.add(distritosDeSanIsidro);
        itemsDistritos.add(distritosDeSanPablo);
        itemsDistritos.add(distritosDeSanRafael);
        itemsDistritos.add(distritosDeSantaBarbara);
        itemsDistritos.add(distritosDeSantoDomingo);
        itemsDistritos.add(distritosDeSarapiqui);
        itemsDistritos.add(distritosDeGuacimo);
        itemsDistritos.add(distritosDeLimonCentral);
        itemsDistritos.add(distritosDeMatina);
        itemsDistritos.add(distritosDePococi);
        itemsDistritos.add(distritosDeSiquirres);
        itemsDistritos.add(distritosDeTalamanca);
        itemsDistritos.add(distritosDeBuenosAires);
        itemsDistritos.add(distritosDeCorredores);
        itemsDistritos.add(distritosDeCotoBrus);
        itemsDistritos.add(distritosDeEsparza);
        itemsDistritos.add(distritosDeGarabito);
        itemsDistritos.add(distritosDeGolfito);
        itemsDistritos.add(distritosDeMontesDeOro);
        itemsDistritos.add(distritosDeOsa);
        itemsDistritos.add(distritosDeParrita);
        itemsDistritos.add(distritosDePuntarenasCentral);
        itemsDistritos.add(distritosDeQuepos);
        itemsDistritos.add(distritosDeAcosta);
        itemsDistritos.add(distritosDeAlajuelita);
        itemsDistritos.add(distritosDeAserri);
        itemsDistritos.add(distritosDeCurridabat);
        itemsDistritos.add(distritosDeDesamparados);
        itemsDistritos.add(distritosDeDota);
        itemsDistritos.add(distritosDeEscazu);
        itemsDistritos.add(distritosDeGoicoechea);
        itemsDistritos.add(distritosDeLeonCortesCastro);
        itemsDistritos.add(distritosDeMontesDeOca);
        itemsDistritos.add(distritosDeMora);
        itemsDistritos.add(distritosDeMoravia);
        itemsDistritos.add(distritoaDePuriscal);
        itemsDistritos.add(distritosDeSanJoseCentral);
        itemsDistritos.add(distritosDeTarrazu);
        itemsDistritos.add(distritosDeTibas);
        itemsDistritos.add(distritosDeTurrubares);
        itemsDistritos.add(distritosDeVasquezDeCoronado);

    }

}