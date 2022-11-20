package com.github.rodindenis.example.multicast.publisher;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        var socket = new DatagramSocket();
        var group = InetAddress.getByName("230.0.0.0");
        var buf = "Hello".getBytes();

        var packet
                = new DatagramPacket(buf, buf.length, group, 8888);
        socket.send(packet);
        socket.close();
    }
}
