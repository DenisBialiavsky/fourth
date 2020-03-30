using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows;
using System.Windows.Data;
using System.Net;
using System.Net.Sockets;
using System.Net.NetworkInformation;

namespace SocketPortScaner
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            List<PortInfo> pi = MainWindow.GetOpenPort();
            listview_scaner.ItemsSource = pi;
        }

        private static List<PortInfo> GetOpenPort()
        {
            IPGlobalProperties properties = IPGlobalProperties.GetIPGlobalProperties();
            IPEndPoint[] udpEndPoints = properties.GetActiveUdpListeners();

            return udpEndPoints.Select(p =>
            {
                return new PortInfo(
                    i: p.Port,
                    local: String.Format("{0}:{1}", p.Address, p.Port),
                    state: p.ToString());
            }).ToList();
        }
    }

    class PortInfo
    {
        public int PortNumber { get; set; }
        public string Local { get; set; }
        public string State { get; set; }

        public PortInfo(int i, string local, string state)
        {
            PortNumber = i;
            Local = local;
            State = state;
        }
    }
}