from Bio import Seq
from Bio import SeqIO

handle = (r'C:/Users/willi/Downloads/rosalind_lcsm(3).txt', 'r')
records = list (SeqIO.parse(handle, "fasta"))

def LCSM(records):
#creating a subset for mins values
    min = records[0]
for rec in records:
    #condition for the for-loop to take each length that is smaller
    #Ordering the list
    if len(rec) < len(min):
        min = rec

subset = []
#iterating and moving the "sub" and creating a subset list
#ordering the list
for sub in range (0, len(min)):
    for move in range (sub, len(min)+1):
        subset.append(min[sub:move])
        subset.remove('')

    
#min = records
#starting at 0 getting the maximum values
maximum = subset

maximum = maximumSet[0]
for maxim in maximumSet:
    #obtaining the maximum values
    if len(maxim) >= len(maximum):
        maximum = maxim

print(maxim)




