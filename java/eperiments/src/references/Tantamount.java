package references;

/*Ïðè âûïîëíåíèè ëþáûõ àðèôìåòè÷åñêèõ îïåðàöèé (óìíîæåíèå, äåëåíèå, ...) îáúåêòû êëàññîâ-îáîëî÷åê
 *  (Integer) àâòîìàòè÷åñêè ðàçâîðà÷èâàþòñÿ â çíà÷åíèÿ ïðèìèòèâíîãî òèïà (int). Ðåçóëüòàòîì ëþáîé
 *   àðèôìåòè÷åñêîé îïåðàöèè òàêæå áóäåò çíà÷åíèå ïðèìèòèâíîãî òèïà. Åñëè ñ ïîìîùüþ == ñðàâíèâàþòñÿ
 *    çíà÷åíèå ïðèìèòâíîãî òèïà è îáúåêò-îáîëî÷êà, òî îáúåêò àâòîìàòè÷åñêè ðàçâîðà÷èâàåòñÿ, è 
 *    ïðîèñõîäèò ñðàâíåíèå äâóõ ïðèìèòèâîâ.*/

//Math - final
public class Tantamount  {
	int yt;
	public int foop() {
		int t;
		return yt;
	}
	
	String s ;//explisitly java initialisation null

	public static void main(String regf[]) {

		//string pull
				//ÊÎÃÄÀ ÌÛ ÈÑÏÎËÜÇÓÅÌ ÄÂÎÉÍÛÅ ÊÎÂÛ×ÊÈ, ÑÍÀ×ÀËÀ ÈÙÅÒÑß ÑÒÐÎÊÀ
				//Â ÏÓËÅ Ñ ÒÀÊÈÌ ÆÅ ÇÍÀ×ÅÍÈÅÌ, ÅÑËÈ ÍÀÕÎÄÈÒÜÑß ÒÎ ÂÎÇÂÐÀÙÀÅÒÑß 
				//ÑÑÛËÊÀ, ÅÑËÈ ÍÅÒ ,ÒÎ ÑÎÇÄÀÅÒÑß ÍÎÂÀß ÑÒÐÎÊÀ Â ÏÓËÅ È ÂÎÇÂÐÀÙÀÅÒÑß ÑÑÛËÊÀ 
				String str1 = "AB";
				String str2 = "A"+"B";//êîìïèëÿòîð ñîáèðàåò ýòî ñðàçó
				//String str2 = "A".concat("B");//áûëîáû ôîëñ
				//ÑÐÀÂÍÈÂÀÅÌ ÀÄÐÅÑÀ, ÓÊÀÇÛÂÀÞÒ ÍÀ ÎÄÍÓ È ÒÓÆÅ ÑÒÐÎÊÓ Â ÏÓËÅ
				System.out.println(str1==str2);//TRUE
				//êîãäà ìû èñïîëüçóåì îïåðàòîð new, ìû ïðèíóæäàåì êëàññ String ñîçäàòü íîâûé îáúåêò ñòðîêè
				//à çàòåì ìû ìîæåì èñïîëüçîâàòü ìåòîä intern() äëÿ òîãî, ÷òîáû ïîìåñòèòü ñòðîêó â ïóë,
				//èëè ïîëó÷èòü èç ïóëà ññûëêó íà äðóãîé îáúåêòString ñ òàêèì æå çíà÷åíèåì.
				String str11= new String("A");
				String str22= new String("A");
				//ÑÐÀÂÍÈÂÀÅÌ ÑÑÛËÊÈ ÓÊÀÇÛÂÀÞÙÈÅ ÍÀ ÐÀÇÍÛÅ ÎÁÚÅÊÒÛ
				System.out.println(str11==str22);//FALSE/
				//EQUALS ÏÅÐÅÃÐÓÆÅÍ ÄËß STRING È ÑÐÀÂÍÈÂÀÅÒ ÑÎÄÅÐÆÈÌÎÅ
				System.out.println(str11.equals(str22));//TRUE
				//ÑÐÀÂÍÈÂÀÅÌ ÑÒÐÎÊÓ ÈÇ ÏÓËÀ ÑÎ ÑÒÐÎÊÎÉ ÑÎÇÄÀÍÍÎÉ ×ÅÐÅÇ NEW
				System.out.println(str11==str2);//FALSE
				str11=str11.intern();//ïîëó÷èòü èç ïóëà ññûëêó íà äðóãîé îáúåêòString ñ òàêèì æå çíà÷åíèåì.
				System.out.println(str11==str2);//true
				
				
				//ÑÎÇÄÀÅÌ ÑÑÛËÎ×ÍÛÅ ÏÅÐÅÌÅÍÍÛÅ ÊËÀÑÑÀ ÎÁÄÆÅÊÒ
				//ÏÐÈÑÂÀÈÂÀÅÌ ÈÌ ÇÍÀ×ÅÍÈÅ ÑÑÛËÎÊ ÍÀ ÎÁÚÅÊÒÛ
				//ÊËÀÑÑÀ ÎÁÄÆÅÊÒ
				Object obj1 = new Object();
				Object obj2 = new Object();
				//EQUALS ÄËß ÎÁÙÅÊÒ ÑÐÀÂÍÈÂÀÅÒ ÑÑÛËÊÈ ÒÀÊ ÆÅ ÊÀÊ ==
				System.out.println(obj1.equals(obj2));//false
				
				
				
				
				
				
				//ÑÎÇÄÀÅÌ ÑÑÛËÎ×ÍÛÅ ÏÅÐÅÌÅÍÍÛÅ ÊËÀÑÑÀ ÎÁÄÆÅÊÒ
				//ÏÐÈÑÂÀÈÂÀÅÌ ÈÌ ÇÍÀ×ÅÍÈÅ ÑÑÛËÎÊ ÍÀ ÎÁÚÅÊÒÛ
				//ÊËÀÑÑÀ String
				Object o1 = new String();
				Object o2 = new String();
				
				//EQUALS ÄËß string ïåðåãðóæåí È ÓÆÅ ÑÐÀÂÍÈÂÀÅÒ ÇÍÀ×ÅÍÈß
				System.out.println(o1.equals(o2));//TRUE
				
				
				String a = "hello1";
				String b = "hello".concat("1");//íå çàíîñèò â ïóë à ñîçäàåò íîâûé îáúåêò
				System.out.println("a="+a+"    b="+b+ "  "+(a==b));//false
				
				
				
				
				
				Object c = new Object();
				Object d = new Object();
				System.out.println("c="+c.hashCode()+"  d= "+ d.hashCode()+"     "+(c.hashCode()==d.hashCode()));
				
				
				
				Character cr1 = 'A';
				Character cr2 = 'A';
				System.out.println("(cr1==cr2)      " + (cr1==cr2));
				Character cr11 = new Character('A');
				Character cr22 = new Character('A');
				System.out.println((cr11==cr22));
				
				
				//Ò.ê. â Integer pool ïîïàäàþò çíà÷åíèÿ îò -128 äî 127
				Integer int1 = 2;
				Integer int2 = 2;
				//int2;//error
				System.out.println((int1==int2));
				System.out.println("int1.equals(int2)      " + (int1.equals(int2)));
				Integer int11 = new Integer(2);
				Integer int22 = new Integer(2);
				System.out.println((int11==int22));
				
				
				Double d1 = 10D;
				Double d2 = 10D;
				System.out.println((d1==d2));
				System.out.println("d1.equals(d2)            " + (d1.equals(d2)));
				
				System.out.println("int s = 1>>0<<1;     " + (1>>0<<1));
				
				int etr=3;
				//etr; //error
				
				Math.abs(3);

				//Math.abs(2) + Math.abs(2);//error
				System.out.println(1%9);
		
		
		double wt = 1d;
		double wr = 1d;
		System.out.println(wt == wr);
		System.out.println(3.0 == 3.0);
		
		
		
		
		
		int []t[],y;
		y = new int[2];
		t= new int[3][2];
		
		
		
		
		
		
		
		System.out.println(String.class);
		
		
		
		
		
		
		
		
		
		
		
		
		if(false && false) {
			System.out.println(0.3 == 0.2 + 0.1);
		}
		
		
		
		
		
		
		
		
		
		Object oi = new Object();
		Object op = new Object();
		System.out.println(oi.equals(op));//false
		
		
		
		
		
		
		
		double dq = Math.sqrt(-1);
		System.out.println(dq);
		System.out.println(Double.NaN==dq);
		dq = dq/0;
		System.out.println(Double.isNaN(dq));
		
		
		
		int sdafddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd=9;
		
		String s = "32";//compalsary initialization otherwise compile error
		System.out.println(s.toUpperCase());
		Tantamount tnt = new Tantamount();
		System.out.println(tnt.s.toUpperCase());
		
		
		
		

	}

}
