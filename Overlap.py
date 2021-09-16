f = open(r"rosalind_grph (7).txt","r") 
k = 3
lines = f.readlines()#function to read files
id = [] #empty set for ids
seq = [] #empty set to hold sequences

def reform(lines): #the reform function is restating our values
    for line in lines: #removing the >
        if line.startswith(">"):
            a = line.replace(">", "")
            a = a.replace("\n", "")
            id.append(a)
        else:
            if len(id) > len(seq): #creating a line function
                line = line.replace("\n","")
                seq.append(line)
            else:
                line = line.replace("\n", "")
                seq[len(id) - 1] = seq[len(id) - 1] + line
    return id , seq 
id, seq = reform(lines) #lines inside of our file will now be reformed

s = [] #empty set to hold the values to be appened
t = [] #empty set to hold the values to be appened

for i in range(len(id)):
    for j in range(len(seq)): #nested for looop

        if i != j:
            if seq[i][-k:] == seq[j][:k]:
                s.append(id[i])
                t.append(id[j])

for i in range(len(s)):
    print(s[i] + " " + t[i])

f.close()
