using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;
using System.Text;


namespace Server
{
    class Program
    {
        static void Main(string[] args)
        {
           
            const string ip = "192.168.43.99";
            const int port = 8081;

            var udpEndPoint = new IPEndPoint(IPAddress.Parse(ip), port);
            var udpSocket = new Socket(AddressFamily.InterNetwork, SocketType.Dgram, ProtocolType.Udp);
            udpSocket.Bind(udpEndPoint);
           
            while (true)
            {
                Console.WriteLine("Handel : " + udpSocket.Handle);
                Console.WriteLine("IP, port : " + udpSocket.LocalEndPoint);
                var buffer = new byte[256];
                var size = 0;
                var data = new StringBuilder();
                EndPoint senderEndPoint = new IPEndPoint(IPAddress.Any, 0);
                do
                {
                    
                    size = udpSocket.ReceiveFrom(buffer, ref senderEndPoint);
                    data.Append(Encoding.UTF8.GetString(buffer));


                }
                while (udpSocket.Available > 0);

                udpSocket.SendTo(Encoding.UTF8.GetBytes("\nСообщение получено!" + "\nTime from server : "
                    + DateTime.Now), senderEndPoint);
                    //+ IPAddress.Parse(((IPEndPoint)udpSocket.LocalEndPoint).Address.ToString()) 
                    
                    //((IPEndPoint)udpSocket.LocalEndPoint).Port.ToString()), senderEndPoint);
               // udpSocket.SendTo(Encoding.UTF8.GetBytes("  Handle: " + udpSocket.Handle), senderEndPoint);
                Console.WriteLine("Handle: "+udpSocket.Handle);


                // Using the LocalEndPoint property.
                //Console.WriteLine("My local IpAddress is : " + IPAddress.Parse(((IPEndPoint)udpSocket.LocalEndPoint).Address.ToString()) + " I am connected on port number " + ((IPEndPoint)udpSocket.LocalEndPoint).Port.ToString());



                Console.WriteLine(data);

            }

        }
    }
}
