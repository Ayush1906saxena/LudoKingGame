class EX
{
  static void exp()
  {
    try{
	Thread.sleep(300);
    }catch(Exception ex){}	
  }
  static void exp1()
  {
    try{
	Thread.sleep(100);
    }catch(Exception ex){}	
  }
  static void exp2()
  {
    try{
	Thread.sleep(50);
    }catch(Exception ex){}	
  }
  static void exp3()
  {
    try{
	Thread.sleep(1000);
    }catch(Exception ex){}	
  }
  static void exp20()
  {
    try{
	Thread.sleep(20);
    }catch(Exception ex){}	
  }
  static void expN(int n)
  {
    try{
	Thread.sleep(n);
    }catch(Exception ex){}	
  }
}