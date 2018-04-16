/*
 * package com.ipartek.formacion.nidea.ejemplos;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.fail;
 * 
 * import java.util.ArrayList; import java.util.Collections;
 * 
 * import org.junit.After; import org.junit.AfterClass; import org.junit.Before;
 * import org.junit.BeforeClass; import org.junit.Test;
 * 
 * public class OrdenacionInterfacesTest {
 * 
 * static ArrayList<Ordenable> coleccion;
 * 
 * @BeforeClass public static void setUpBeforeClass() throws Exception {
 * 
 * coleccion = new ArrayList<Ordenable>();
 * 
 * }
 * 
 * @AfterClass public static void tearDownAfterClass() throws Exception {
 * coleccion = null; }
 * 
 * @Before public void setUp() throws Exception {
 * 
 * coleccion = new ArrayList<Ordenable>();
 * 
 * VehiculoElectrico e1 = new VehiculoElectrico();
 * 
 * CirculoColoreado e2 = new CirculoColoreado(); e2.setRadio(1);
 * 
 * VehiculoElectrico e3 = new VehiculoElectrico(); e3.setPuertas(0);
 * 
 * CirculoColoreado e4 = new CirculoColoreado(); e4.setRadio(9);
 * 
 * coleccion.add(e1); coleccion.add(e2); coleccion.add(e3); coleccion.add(e4);
 * 
 * }
 * 
 * @After public void tearDown() throws Exception { coleccion = null; }
 * 
 * @Test public void testBubbleSort() {
 * 
 * Utilidades.bubbleSort(coleccion);
 * 
 * assertEquals(0, coleccion.get(0).getValor()); assertEquals(1,
 * coleccion.get(1).getValor()); assertEquals(3, coleccion.get(2).getValor());
 * assertEquals(9, coleccion.get(3).getValor());
 * 
 * Ordenable elemento = coleccion.get(0);
 * 
 * if (elemento instanceof CirculoColoreado) { CirculoColoreado c =
 * (CirculoColoreado) elemento;
 * 
 * } else if (elemento instanceof VehiculoElectrico) {
 * 
 * VehiculoElectrico ve = (VehiculoElectrico) elemento; } else {
 * fail("No esperamos esta Clase de Objetos"); }
 * 
 * }
 * 
 * @Test public void testCollectionSort() {
 * 
 * Collections.sort(coleccion, new ComparatorOrdenables());
 * 
 * assertEquals(0, coleccion.get(0).getValor()); assertEquals(1,
 * coleccion.get(1).getValor()); assertEquals(3, coleccion.get(2).getValor());
 * assertEquals(9, coleccion.get(3).getValor());
 * 
 * Collections.reverse(coleccion);
 * 
 * assertEquals(9, coleccion.get(0).getValor()); assertEquals(3,
 * coleccion.get(1).getValor()); assertEquals(1, coleccion.get(2).getValor());
 * assertEquals(0, coleccion.get(3).getValor());
 * 
 * }
 * 
 * }
 * 
 */