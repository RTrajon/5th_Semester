//super class
class Notification{
    public MsgNotification msgNotification;//initializes atributes
    private CallNotification callNotification;//initialzes atributes

    //spacial method or Constructor 
    public Notification(){

        //create obj of classes (that will call the sub class constuctor)
        this.msgNotification = new MsgNotification();
        this.callNotification = new CallNotification();
    }
    //this method will do nothing unless override the notify() methods of subclass
    void notify(){
        msgNotification.notify();//call method of atributes
        callNotification.notify();//call method of atributes
    }
}
//sub class Constructor
class MsgNotification{
    //method with no body
    void notify(){
    }
}
//sub class Constructor
class CallNotification{
    //method with no body
    void notify(){
    }
}