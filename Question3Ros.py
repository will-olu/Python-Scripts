from Bio import Seq
from Bio import SeqIO

handle = open(r'C:/Users/willi/Downloads/rosalind_gc (2).txt', "r")

records = list(SeqIO.parse(handle, "fasta"))

Ssets= records.split(', ')
#put string 
s1 = records[1]
s2 = records[3]

#R is the comparision and iterating function/method
def R(s1, s2):
    #initialize the transitions and create a set for them
    transitions = set([('A', 'G'), ('G', 'A'), ('C', 'T'), ('T', 'C')])
    #initializing a comparsion value for the set
    ratio = (True: 0.0, False:0.0)
    #if the lengths are the same
    if len(s1) == len(s2):
        for power in problem(s1,s2):
            if power[0] != p[1]:
                power[p in transitions] +=1
        return power[True]/ power[False]

print(R(s1,s2))
            
