package org.example.mislugares;
import org.example.mislugares.GeoPunto;

/**
 * Created by juancri on 24/05/16.
 * @version 1.0
 *
 */
public class GeoPuntoAlt extends GeoPunto {
    private  double altura;

    public GeoPuntoAlt(double longitud, double latitud, double altura) {
        super(longitud, latitud);
        this.altura=altura;
    }

    public GeoPuntoAlt(double longitud, double latitud){
        super(longitud, latitud);
        this.altura=0;
    }

    @Override
    public String toString()
    {
        return super.toString() + " altura: " + altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double distancia(GeoPuntoAlt puntoAlt){
        final double RADIO_TIERRA = 6371000; // en metros

        double dLat = Math.toRadians(latitud - puntoAlt.getAltura());

        double dLon = Math.toRadians(longitud - puntoAlt.longitud);

        double lat1 = Math.toRadians(puntoAlt.latitud);

        double lat2 = Math.toRadians(latitud);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +

                Math.sin(dLon/2) * Math.sin(dLon/2) *

                        Math.cos(lat1) * Math.cos(lat2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double distanciaA= c * RADIO_TIERRA;
        double diferenciaAlt= altura - puntoAlt.altura;
        double diferenciaAlt2 = diferenciaAlt*diferenciaAlt;

        return Math.sqrt((distanciaA*distanciaA)-diferenciaAlt2);

    }


}
