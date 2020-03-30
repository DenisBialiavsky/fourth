using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace udp
{
    class Program
    {
        static void Main(string[] args)
        {

            const string ip = "127.0.0.1";
            const int port = 8081;

            var udpEndPoint = new IPEndPoint(IPAddress.Parse(ip), port);
            var udpSocket = new Socket(AddressFamily.InterNetwork, SocketType.Dgram, ProtocolType.Udp);
            udpSocket.Bind(udpEndPoint);
            

            while (true) {
                Console.WriteLine("Введите сообщение : ");
                var message = Console.ReadLine();

                var serverEndPoint = new IPEndPoint(IPAddress.Parse(ip), port);

                udpSocket.SendTo(Encoding.UTF8.GetBytes(message + "\nTime from client "+DateTime.Now), serverEndPoint);
                
                //Console.WriteLine("Handle: " + udpSocket.Handle);
                //Console.WriteLine("My local IpAddress is : " + IPAddress.Parse(((IPEndPoint)udpSocket.LocalEndPoint).Address.ToString()) + " I am connected on port number " + ((IPEndPoint)udpSocket.LocalEndPoint).Port.ToString());

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

                Console.WriteLine(data);
                Console.ReadLine(  );
            }
        }
    }
}
