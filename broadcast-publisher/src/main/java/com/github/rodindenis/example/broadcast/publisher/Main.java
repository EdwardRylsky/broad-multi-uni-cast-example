package com.github.rodindenis.example.broadcast.publisher;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        var socket = new DatagramSocket();
        socket.setBroadcast(true);

        byte[] buffer = "Hello".getBytes();

        var address = InetAddress.getByName("255.255.255.255");

        DatagramPacket packet
                = new DatagramPacket(buffer, buffer.length, address, 9999);
        socket.send(packet);
        socket.close();
    }
}
