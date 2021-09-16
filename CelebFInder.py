from random import randrange

def naive_celebrity(graph):
    n = len(graph) - 1
    celeb = 0
    for node in range(0,n):
        if(graph[node][0]== False):
            celeb = node
    return celeb
n=100
G=[[randrange(2) for i in range(n) for i in range(n)]:
c=randrange(n) # make a celebrity
print("I'm making "+str(c)+" the celebrity...")
for i in range(n):
    G[i][c]=True
    G[c][i]=False
