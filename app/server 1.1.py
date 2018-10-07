import socket
import threading as t
import random as r

#192.168.43.181 internal

ip=socket.gethostbyname(socket.gethostname()) # internal ip
ip='0.0.0.0'
#ip= socket.gethostname() #localhost only
port=8082
# Bind the socket to the port
print("Server={},port={}".format(ip,port))

def listen():
    count=0
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((ip, port))
    s.listen(1)
    print("listener runn")
    while 1:
        conn, addr = s.accept()       
        t_name='x'+str(r.randint(10000,99999)) #random name gen for thread 'x12487'
        x=[]
        x.append(t_name) # append in a list
        print("New connection name:{} ip:{}".format(t_name,addr))
        x[0]=t.Thread(target=run,args=(conn,addr,)).start() #name a thread
        x.pop() # empty list for next iteration
        runn_thread=int(t.activeCount())-2
        print("Total threads:{}".format(runn_thread))


def run(conn,addr):
    print("Threaad run...")
    while 1:
        try:
            data = conn.recv(2000)
            data=data.decode("utf-8")# decode data
            if data!="":
                print(data)
                inform(data)
        except:
            print("remote con dc")
            break # thread will die
        if data=='Hello':
            print("Sending ACk")
            conn.sendall(b'Ack by server')
        else:
            pass
    print("closing conn")
    conn.close()


def inform(data):
    print("======T0his Dummy function will inform aasra and POlice station=== ")
    print("Brodcasting {}".format(data))
listen()







