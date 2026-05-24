# Memorama Swing

## Descripción

**Memorama Swing** es una implementación clásica del juego de memoria (Memorama) desarrollada en **Java** utilizando la biblioteca **Swing** para la interfaz gráfica. El proyecto demuestra conceptos fundamentales de programación orientada a objetos, patrones de diseño y desarrollo de aplicaciones de escritorio en Java.

El juego presenta diferentes temas (Animales, Frutas, Personajes) y modos de juego (Jugador vs Máquina, Dos Jugadores), ofreciendo una experiencia interactiva y entretenida.

## Estructura del Proyecto

El repositorio contiene **dos versiones del mismo proyecto** adaptadas para diferentes versiones de NetBeans:

### 1. **NetBeans IDE 30 Version** (Maven)
```
NetBeans IDE 30 Version/
├── pom.xml                          # Configuración de Maven
├── src/
│   └── main/
│       ├── java/com/myname/memorama/
│       │   ├── Memorama.java
│       │   └── util/
│       │       └── ImagenUtils.java
│       └── resources/imagenes/      # Recursos gráficos
└── target/                          # Compilación
```

**Características:**
- Gestión de dependencias mediante Maven
- Estructura modular moderna
- Compatible con Java 26+

### 2. **NetBeans IDE 8.2 Version** (Ant)
```
NetBeans IDE 8.2 Version/
├── build.xml                        # Configuración de Ant
├── nbproject/
├── src/
│   ├── modelo/                      # Clases del modelo
│   ├── vista/                       # Interfaz gráfica
│   └── imagenes/                    # Recursos gráficos
├── build/                           # Compilación
└── dist/Memorama.jar               # JAR ejecutable
```

**Características:**
- Gestión de proyecto con Ant (herramienta tradicional)
- Estructura compatible con NetBeans 8.2
- Ejecutable como archivo JAR

---

## Características del Juego

### Modos de Juego
- **Jugador vs Máquina**: Compite contra la inteligencia artificial
- **Dos Jugadores**: Juega contra otro jugador en el mismo equipo

### Temas Disponibles
1. **Animales**: Gato, Perro, León, Tigre
2. **Frutas**: Manzana, Plátano, Sandía, Uva
3. **Personajes**: Mario, Luigi, Sonic, Pikachu

### Mecánica del Juego
- Objetivo: Encontrar todas las parejas de cartas
- Al hacer clic en una carta, se voltea para revelar su imagen
- Si encuentras dos cartas iguales, quedan destapadas (encontradas)
- Si no coinciden, vuelven a voltearse

---

## Arquitectura

El proyecto sigue un patrón **MVC (Model-View-Controller)**:

### Modelo (`modelo/`)
- **`Carta.java`**: Representa una carta individual con:
  - Nombre e imagen asociada
  - Estado de volteo (tapada/destapada)
  - Estado de encontrada (pareja formada)

- **`Memorama.java`**: Clase abstracta que define la estructura base:
  - Gestiona la lista de cartas
  - Proporciona método de barajado

- **`MemoramaAnimales.java`**: Implementación específica para animales
- **`MemoramaFrutas.java`**: Implementación específica para frutas
- **`MemoramaPersonajes.java`**: Implementación específica para personajes
- **`Jugador.java`**: Gestiona información del jugador (puntuación, etc.)

### Vista (`vista/`)
- **`FrmMenuPrincipal.java`**: Ventana principal con:
  - Selector de tema (Animales, Frutas, Personajes)
  - Selector de modo de juego
  - Botón para iniciar partida

- **`FrmJuegoMemorama.java`**: Ventana del juego con:
  - Grid de cartas clickeable
  - Lógica de turnos
  - Contador de puntuación

### Utilidades
- **`ImagenUtils.java`**: Funciones auxiliares para carga y manipulación de imágenes
- **`ImagenNoEncontradaException.java`**: Excepción personalizada para errores de recursos

---

## Cómo Ejecutar

### Opción 1: NetBeans IDE 30 Version (Maven)

```bash
# Compilar
mvn clean compile

# Ejecutar
mvn exec:java

# Crear JAR ejecutable
mvn clean package
```

### Opción 2: NetBeans IDE 8.2 Version (Ant)

```bash
# Compilar
ant clean build

# Ejecutar
ant run

# Crear JAR ejecutable
java -jar dist/Memorama.jar
```

### Opción 3: Desde NetBeans IDE
1. Abre NetBeans IDE
2. Selecciona "File" → "Open Project"
3. Navega a la carpeta de la versión deseada
4. Presiona F6 o selecciona "Run" → "Run Project"

---

## Requisitos

- **Java Development Kit (JDK)**: 
  - Versión 8 o superior (para la versión 8.2 de NetBeans)
  - Versión 26 o superior (para la versión 30 de NetBeans)
- **NetBeans IDE**: Cualquiera de las versiones especificadas
- **Maven** (para la versión Maven) o **Ant** (ambas versiones)

---

## Diseño de la Interfaz

### Paleta de Colores
- Fondo: Gris oscuro (#1e1e1e)
- Título: Dorado (#ffd700)
- Texto: Blanco (#ffffff)
- Botones: Azul acero (#4682b4)

### Componentes Principales
- **Etiquetas**: Información del menú
- **Combo Boxes**: Selección de tema y modo
- **Botón "Jugar"**: Inicia la partida
- **Grid de Cartas**: Interfaz principal del juego

---

## Ejemplo de Uso

1. **Iniciar la aplicación**: Ejecuta el proyecto desde NetBeans o el JAR
2. **Seleccionar tema**: Elige entre Animales, Frutas o Personajes
3. **Elegir modo**: Selecciona Jugador vs Máquina o Dos Jugadores
4. **Jugar**: Haz clic en las cartas para revelarlas y forma parejas
5. **Ganar**: Encuentra todas las parejas para completar la partida

---

## Diferencias entre Versiones

| Aspecto | NetBeans 30 | NetBeans 8.2 |
|---------|------------|-------------|
| **Constructor de Proyectos** | Maven | Ant |
| **Archivo de Configuración** | `pom.xml` | `build.xml` |
| **Estructura de Directorios** | Maven estándar | NetBeans estándar |
| **Versión de Java** | 26+ | 8+ |
| **Empaques** | JAR (Maven) | JAR (Ant) |

Ambas versiones contienen **exactamente el mismo código fuente** y **funcionalidad**, solo diferenciando en la herramienta de construcción.
