package br.newtonpaiva.tarefa8;

import java.time.LocalDateTime;
import java.util.Objects;

public class Produto {
    private String id;
    private String title;
    private String brand;
    private Double normalPrice;
    private Double lowPrice;
    private Double highPrice;
    private Integer oferta;
    private String categoria1;
    private String categoria2;
    private LocalDateTime dateTime;
    private String atributos;
    private Integer sinStock;
    private Integer page;
    private Double ahorro;
    private Double ahorroPercent;
    private Double kilo;

    public Produto(
            String title, String brand, Double normalPrice, Double lowPrice, Double highPrice, Integer oferta,
            String categoria1, String categoria2, LocalDateTime dateTime, String atributos, Integer sinStock,
            Integer page, Double ahorro, Double ahorroPercent, Double kilo
    ) {
        this.title = title;
        this.brand = brand;
        this.normalPrice = normalPrice;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
        this.oferta = oferta;
        this.categoria1 = categoria1;
        this.categoria2 = categoria2;
        this.dateTime = dateTime;
        this.atributos = atributos;
        this.sinStock = sinStock;
        this.page = page;
        this.ahorro = ahorro;
        this.ahorroPercent = ahorroPercent;
        this.kilo = kilo;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = categoria2.substring(0,4).toUpperCase() + id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(Double normalPrice) {
        this.normalPrice = normalPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Integer getOferta() {
        return oferta;
    }

    public void setOferta(Integer oferta) {
        this.oferta = oferta;
    }

    public String getCategoria1() {
        return categoria1;
    }

    public void setCategoria1(String categoria1) {
        this.categoria1 = categoria1;
    }

    public String getCategoria2() {
        return categoria2;
    }

    public void setCategoria2(String categoria2) {
        this.categoria2 = categoria2;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getAtributos() {
        return atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    public Integer getSinStock() {
        return sinStock;
    }

    public void setSinStock(Integer sinStock) {
        this.sinStock = sinStock;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Double getAhorro() {
        return ahorro;
    }

    public void setAhorro(Double ahorro) {
        this.ahorro = ahorro;
    }

    public Double getAhorroPercent() {
        return ahorroPercent;
    }

    public void setAhorroPercent(Double ahorroPercent) {
        this.ahorroPercent = ahorroPercent;
    }

    public Double getKilo() {
        return kilo;
    }

    public void setKilo(Double kilo) {
        this.kilo = kilo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(title, produto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Produto" + "\n" +
                "---------------------------------------------" + "\n" +
                "id=" + id + "\n" +
                "title=" + title + "\n" +
                "brand=" + brand + "\n" +
                "normalPrice=" + normalPrice + "\n" +
                "lowPrice=" + lowPrice + "\n" +
                "highPrice=" + highPrice + "\n" +
                "oferta=" + oferta + "\n" +
                "categoria1=" + categoria1 + "\n" +
                "categoria2='" + categoria2 + "\n" +
                "dateTime=" + dateTime + "\n" +
                "atributos=" + atributos + "\n" +
                "sinStock=" + sinStock + "\n" +
                "page=" + page + "\n" +
                "ahorro=" + ahorro + "\n" +
                "ahorroPercent=" + ahorroPercent + "\n" +
                "kilo=" + kilo + "\n";
    }
}


