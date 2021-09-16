from Bio.Seq import Seq
from Bio import SeqIO


#handle = open(r"C:/Users/willi/Downloads/rosalind_dna (5).txt" , "r")

#sequence = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"
#records = ((SeqIO.parse(handle, "fasta")))
#sequence = handle.read()

#ACGT order
#adenosine = sequence.count('A')
#cytosine = sequence.count('C')
#guanine = sequence.count('G')
#tyrosine = sequence.count('T')
    
   
    
           

#print(adenosine, cytosine, guanine, tyrosine)

seq = open('C:/Users/willi/Downloads/rosalind_dna (5).txt', 'r')
#read the line as a sequence
seq = seq.read()
#initialize at 0
countA = 0
countC = 0
countG = 0
countT = 0

#parse the sequence for a value
for n in seq:
    if n == 'A':
        countA += 1
    if n == 'C':
        countC += 1
    if n == 'G':
        countG += 1
    if n == 'T':
        countT += 1


print (str(countA) + ' ' + str(countC) + ' ' + str(countG) + ' ' + str(countT))

#if you are using linux this is how you would find the data cat file.txt | perl -ne '$,=" "; print y/A//, y/C//, y/G//, y/T//




