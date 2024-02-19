import my_debugger
from my_debugger import *
import my_debugger_defines
from my_debugger_defines import *

print("Please enter the PID of the process to attach to: ")
foo = int(input())

debugger = my_debugger.debugger()
debugger.attach(foo)

threadIDS = debugger.enumerate_threads()

buffer = debugger.get_thread_context(threadIDS)
print(buffer.Edi)
print(buffer.Ebx)
print(buffer.Edx)
print(buffer.Ecx)
print(buffer.Eax)
print(buffer.Ebp)
print(buffer.Eip)
