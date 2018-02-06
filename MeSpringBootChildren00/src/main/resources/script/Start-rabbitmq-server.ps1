#
#('setx -m ERLANG_SERVICE_MANAGER_PATH "C:\Program Files\erl9.2\erts-9.2\bin"'); & "C:\Program Files\RabbitMQ Server\rabbitmq_server-3.6.14\sbin\rabbitmq-service.bat" start

($env:ERLANG_SERVICE_MANAGER_PATH = "C:\Program Files\erl9.2\erts-9.2\bin"); (& "C:\Program Files\RabbitMQ Server\rabbitmq_server-3.6.14\sbin\rabbitmq-service.bat" start)
#; (redis-server --sentinel)
; (& "C:\Program Files\Redis\redis-server.exe")

#(cd c:\Users\sqsga\OneDrive\Tools\ViATc-master\) ; (& "C:\Program Files\AutoHotkey\AutoHotkey.exe" c:\Users\sqsga\OneDrive\Tools\ViATc-master\viatc-0.6.0.ahk)

#('setx -m ERLANG_HOME "C:\Program Files\erl9.2\erts-9.2"')
#to the folder containing .
# "\erlsrv.exe" not found
#
#
#"erlsrv.exe"
