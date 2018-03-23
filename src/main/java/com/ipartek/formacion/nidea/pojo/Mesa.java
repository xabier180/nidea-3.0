//1.definicion package
package com.ipartek.formacion.nidea.pojo;

//2. Imports => ahora mismo no tenemos ninguno

//3. definicion Clase
/**
 * 
 * @author ur00
 *
 */
public class Mesa implements Cloneable {

	/**
	 * precio en €
	 */
	public static final int PRECIO_PATA = 1;
	public static final int PRECIO_M2 = 5;
	public static final int PRECIO_MATERIAL_MADERA = 4;
	public static final int PRECIO_MATERIAL_ACERO = 6;
	public static final int PRECIO_MATERIAL_ALUMINIO = 5;
	public static final int PRECIO_MATERIAL_PLASTICO = 2;
	public static final int PRECIO_COLOR_CUSTOM = 23;
	public static final String PRECIO_COLOR_NAME_CUSTOM = "custom";

	public static final int MATERIAL_MADERA = 1;
	public static final int MATERIAL_ACERO = 2;
	public static final int MATERIAL_ALUMINIO = 3;
	public static final int MATERIAL_PLASTICO = 4;

	public static final String[] MATERIALES_LISTA = { "madera", "acero", "aluminio", "plastico" };
	public static final int[] MATERIALES_LISTA_CODIGO = { 1, 2, 3, 4 };

	// 4. Atributos siempre PRIVATE para mantener la encapsulacion
	private int numeroPatas;
	private int dimension; // metros cuadrados
	private String color;
	private boolean custom;
	private int material;

	public Mesa() {

		// llamar siempre a super
		super();

		// inicializar los atributos
		this.numeroPatas = 4;
		this.dimension = 1;
		this.color = "blanco";
		this.custom = false;
		this.material = MATERIAL_MADERA;

	}

	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	public static int getPrecioPata() {
		return PRECIO_PATA;
	}

	public static int getPrecioM2() {
		return PRECIO_M2;
	}

	public static int getPrecioMaterialMadera() {
		return PRECIO_MATERIAL_MADERA;
	}

	public static int getPrecioMaterialAcero() {
		return PRECIO_MATERIAL_ACERO;
	}

	public static int getPrecioMaterialAluminio() {
		return PRECIO_MATERIAL_ALUMINIO;
	}

	public static int getPrecioMaterialPlastico() {
		return PRECIO_MATERIAL_PLASTICO;
	}

	public static int getPrecioColorCustom() {
		return PRECIO_COLOR_CUSTOM;
	}

	public static String getPrecioColorNameCustom() {
		return PRECIO_COLOR_NAME_CUSTOM;
	}

	public static int getMaterialMadera() {
		return MATERIAL_MADERA;
	}

	public static int getMaterialAcero() {
		return MATERIAL_ACERO;
	}

	public static int getMaterialAluminio() {
		return MATERIAL_ALUMINIO;
	}

	public static int getMaterialPlastico() {
		return MATERIAL_PLASTICO;
	}

	public static String[] getMaterialesLista() {
		return MATERIALES_LISTA;
	}

	public static int[] getMaterialesListaCodigo() {
		return MATERIALES_LISTA_CODIGO;
	}

	public Mesa(int material) {
		this(); // llamar siempre al constructor por defecto
		this.material = material;
	}

	public Mesa(int material, int dimension) {
		this(material);
		this.dimension = dimension;
	}

	public int getNumeroPatas() {
		return numeroPatas;
	}

	/**
	 * Si numeroPatas < 0 asignamos valor 1, else numeroPatas
	 * 
	 * @param numeroPatas
	 *            int
	 */
	public void setNumeroPatas(int numeroPatas) {
		this.numeroPatas = (numeroPatas <= 0) ? 1 : numeroPatas;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaterial() {
		return material;
	}

	public void setMaterial(int material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Mesa [numeroPatas=" + numeroPatas + ", dimension=" + dimension + ", color=" + color + ", material="
				+ material + "]";
	}

	/**
	 * Calculamos el precio de la mesa en funcion de los materiales usados.
	 * 
	 * @see consultar todas las constantes definidas para los precios
	 * @return int precio en €
	 */
	public int getPrecio() {

		int resul = 0;

		resul += this.numeroPatas * PRECIO_PATA;
		resul += this.dimension * PRECIO_M2;

		if (PRECIO_COLOR_NAME_CUSTOM.equalsIgnoreCase(this.color)) {
			resul += PRECIO_COLOR_CUSTOM;
		}

		switch (this.material) {
		case MATERIAL_ACERO:
			resul += PRECIO_MATERIAL_ACERO;
			break;
		case MATERIAL_ALUMINIO:
			resul += PRECIO_MATERIAL_ALUMINIO;
			break;
		case MATERIAL_MADERA:
			resul += PRECIO_MATERIAL_MADERA;
			break;
		case MATERIAL_PLASTICO:
			resul += PRECIO_MATERIAL_PLASTICO;
			break;

		default:
			break;
		}

		return resul;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + dimension;
		result = prime * result + material;
		result = prime * result + numeroPatas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (dimension != other.dimension)
			return false;
		if (material != other.material)
			return false;
		if (numeroPatas != other.numeroPatas)
			return false;
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
