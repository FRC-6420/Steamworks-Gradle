package frc.team6420.robot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class Selector {
    private HashMap<DigitalInput, Command> commands = new HashMap<DigitalInput,Command>();

    public void addCommand( DigitalInput port, Command command ){
        commands.put( port,  command );
    }

    public Command getSelected(){
        Iterator<Map.Entry<DigitalInput, Command>> it = commands.entrySet().iterator();
        while( it.hasNext() ){
            Entry<DigitalInput, Command> pair = it.next();
            if( !(pair.getKey()).get() ){
                return pair.getValue();
            }
            it.remove();
        }
        return null;
    }
}
