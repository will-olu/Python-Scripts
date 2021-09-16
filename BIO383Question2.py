from Bio import Entrez
from Bio import SeqIO

#calling the Entrez function creating a variable for the fasta files
#creating a list for the values that will be parsed
Entrez.email = "aoluajeigbe@luc.edu"
handle = Entrez.efetch(db = "nucleotide", id = ["NM_002037, NR_073358, NM_204821, JX308821, JX445144, NM_001003102, JX398977, JX317622"], rettype = "fasta")
records = list (SeqIO.parse(handle, "fasta"))

#initializing the length and the size values for the for loop
shortest = 0
length = 0

#next for every nucleotide sequence list of record values starting form 0 to the length of the string
for nucleotide in range(0, len(records)):
    #creation of variable to hold the length of the nucleotide sequence in the fasta format
    rec = records[nucleotide].seq
    #The length of the nucleotide sequence will be held in the lengthNext variable
    lengthNext = len(rec)
    #Conditional to set for if there is nothing in the nucleotide sequence
    if nucleotide == 0:
        length =lengthNext
    else:
        #this conditional will iterate over the values in the for loop
        #each value will be looked at and then compared to the next value
        #the new shortest value becomes the seq and is compared to the next
        if lengthNext < length:
            shortest = nucleotide
            length = lengthNext
        
        
    
print(records[shortest].description)#prints descrption
print(records[shortest].seq)#prints sequence
