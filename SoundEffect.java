import java.applet.*;
import java.net.*;
class SoundEffect
{
  AudioClip step,open;
  void loadSound()
  {
   try
   {
       open=Applet.newAudioClip(getClass().getResource("/sounds/open.wav"));
       step=Applet.newAudioClip(getClass().getResource("/sounds/step.wav"));
   }catch(Exception ex){}
 } 
}