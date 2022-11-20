package com.github.rodindenis.example.multicast.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        var socket = new MulticastSocket(8888);
        var group = InetAddress.getByName("230.0.0.0");
        var buf = new byte[256];

        socket.joinGroup(group);

        var packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        var received = new String(
                packet.getData(),
                0,
                packet.getLength());

        socket.leaveGroup(group);
        socket.close();
    }
}
