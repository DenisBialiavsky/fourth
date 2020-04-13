using System.Runtime.InteropServices;

namespace BankServerCSharp
{
    [ComVisible(true)]  // This is mandatory.
    [InterfaceType(ComInterfaceType.InterfaceIsDual)]
    public interface IBank
    {
        string BankName { get; set; }      // A property
        IAccount FirstAccount { get; }         // Another one of type IDispatch
    }

    [ComVisible(true)]  // This is mandatory.
    [ClassInterface(ClassInterfaceType.None)]
    public class Bank : IBank
    {
        private string Name = "";
        private readonly Account First;

        public Bank() { First = Account.MakeAccount(); }

        public string BankName
        {
            get { return Name; }
            set { Name = value; }
        }

        public IAccount FirstAccount
        {
            get { return First; }
        }
    }
}