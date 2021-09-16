#From shell, test and understand this code

#building a list
bases = list()
bases
#same as
bases = []
bases
bases.append('adenine')
bases
#lists are mutable (can be modified)
bases.append('cytosine')
bases
bases.append('guanine')
bases.append('thymine')
bases

#for loop syntax
for item in bases:
    print(item)

#make a new list with only first letter of 
#each base, but capitalize it

#define empty list
shortbases = []
for base in bases:
    new = base[0].upper() #get first character & capitalize
    shortbases.append(new) #append list with new base

shortbases

#Start a Python script with File -> New File
#use a for loop to reverse a string
string = 'flow' #define string
revstring = '' #define empty string
for s in string:
    revstring = s + revstring
print(revstring)

#Run -> Run Module or press the F5 key to execute code
#need to save Python script before running, e.g. test.py
#try different strings, e.g. edit, doom

#how do things change if we edit the above to this?
revstring = '' #define empty string
for s in string:
    revstring = s + revstring
    print(revstring)

#the growing revstring is printed each time through the loop
#indentations define code blocks in Python
    
#for loops with integers
#use the range function
for i in range(10):
    print(i)

#what if you want 1-10?
#to get help on any function:
help(range)

#what if you want 1-10?
for i in range(1,11):
    print(i)

#what if you want even numbers from 2-10?
for i in range(2,10,2):
    print(i)

#remember Python goes up to, but doesn't include the stop number
#range(start,stop,step)
for i in range(2,11,2):
    print(i)

#conditions
expression = 125
if expression > 100:
    print("gene is highly expressed")
else:
    print("gene is lowly expressed")

#change value of expression, see what happens

#add a medium level
expression = 77
if expression > 100:
    print("gene is highly expressed")
elif expression > 25: #think "else if"
    print("gene is intermediately expressed")
else:
    print("gene is lowly expressed")

#Boolean operators (true or false?)
# Is 3 equal to 5?
3 == 5
# Is 3 not equal to 5?
3 != 5
# Is 3 less than or equal to 5?
3 <= 5

len("ATGC") > 5

"GAATTC".count("T") > 1

"V" in ["V", "W", "L"]

#combine for loops and conditions
accs = ['ab56', 'bh84', 'hv76', 'ay93', 'ap97', 'bd72']
for acc in accs:
    if acc.startswith('a'):
        print(acc)

#complex conditions
for acc in accs:
    if acc.startswith('a') and acc.endswith('3'):
        print(acc)

for acc in accs:
    if acc.startswith('a') or acc.endswith('6'):
        print(acc)

for acc in accs:
    if acc.startswith('a') and not acc.endswith('6'):
        print(acc)

'''practice reading and writing files

 make a testin.txt file - save to Desktop

Homo sapiens
Mus musculus
Drosophila melanogaster
'''

#edit your test.py script to
infile = open('testin.txt', 'r')
instring = infile.read()
print(instring)
#click Run->Run Module or F5 to run

#Did you get an error?
#if Python can't find the file,
#check what directory you are in with the os module

#first import the module:
import os
#command to get current working directory (folder)
os.getcwd()

#save testin.txt in the current working directory & rerun
#or you could use os.chdir() to move to where the saved file is

#show that .read reads in the entire file into one string,
#including newline characters
instring

#Show another way to read file, this time one line at a time
#Also show how to write output

outfile = open('testout.txt','w') #w means write

for line in open('testin.txt'):
    #split the line string on all whitespace to a list
    genus_species = line.split()
    #write just the species to outfile
    outfile.write(genus_species[1])
#close the file
outfile.close()

#testout.txt is now located in the same folder as test.py
#rerun with \n
#rerun with split(' ')

