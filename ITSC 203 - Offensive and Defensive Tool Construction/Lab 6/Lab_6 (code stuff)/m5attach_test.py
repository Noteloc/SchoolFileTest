import my_debugger
from my_debugger import *
import my_debugger_defines
from my_debugger_defines import *
import keyboard

print("Please enter the PID of the process to attach to: ")
foo = int(input())

debugger = my_debugger.debugger()
debugger.attach(foo)
debugger.run()

#def run(self):
#        
#        # Now we have to poll the debuggee for 
#        # debugging events           
#        while self.debugger_active == True:
#            self.get_debug_event()
#            if keyboard.is_pressed('q'):
#                self.detach()
#                break
# THIS IS MY EDITED VERSION OF THE MY_DEBUGGER FUNCTION FOR PROBLEM 2