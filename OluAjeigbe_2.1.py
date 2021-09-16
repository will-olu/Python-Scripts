infile = open("sample_text.txt") #text values

outfile = open("OluAjeigbe_2.1.csv", "r")

values = []
infile= open(infile).read().split()
values = infile

def insertionSort(values): #function to work with our values
    for index in range(1, len(values)): #going throught he range of values indexed which we will use to compare 0 to 1 in my following loop
        startPoint = values[index] #where the comparison values will start
        current = index # the current index of our value
        
        while current > 0 and values[index - 1] > startPoint: #making a nested while group in our for loop compares the current index from the index that was present before to be able to get comparisons until the conditions of sorting are met
            value[current] = values[current-1] #conditions to compare our index startpoint
            current -= 1

            values[current] = startPoint

      
    
outfile.write(insertionSort(values))

outfile.close()
