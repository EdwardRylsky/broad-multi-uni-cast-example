package com.github.rodindenis.example.broadcast.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        DatagramSocket socket = new DatagramSocket(9999);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + received);
        socket.close();
    }
}
