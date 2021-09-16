#Dictionaries
#start an empty dict
movies = {}
movies
#same as
movies = dict()
movies
#to add entries to dictionary
# dictname[<key>] = <value>
movies['Jaws'] = 1975
movies['Psycho'] = 1960
movies['Rocky'] = 1976
movies['Fargo'] = 1996
movies['Up'] = 2008

print(movies)

#keys are overwritten, keys must be unique
movies['Up'] = 2009
movies

#movies['Pycho'] #KeyError
movies['Psycho']

#to test if a key is in a dictionary:
'Psycho' in movies
'Heat' in movies

#print('Jaws was released in ' + movies['Jaws'] + '.') #TypeError
print('Jaws was released in ' + str(movies['Jaws']) + '.')

#pull out each key and value in movies
#and print with an arrow in between
for key, value in movies.items():
    print(key + " -> " + str(value))

#make a function to print a sentence about any movie.
#def means define a function
#release is name of function (can be anything)
#movie and yeardict are required arguments for the release function
def release(movie, yeardict):
    year = yeardict[movie]
    info = '{} was released in {}.'.format(movie, year)
    return info

#calling the function returns the info string
release('Psycho',movies)
#we see what is returned in shell, but if we were writing a script,
#we need to print what is returned to see it
print(release('Psycho',movies))
#can also assign what is returned to a new variable, movieinfo
movieinfo = release('Up', movies)
print(movieinfo)

#variables that we create inside a function only exist inside the function
#for example, trying to print year returns an error
print(year)

#can loop through all keys in the movies dictionary,
#calling the release function for each one
for m in movies.keys():
    print(release(m,movies))

#Extra info not crucial for this course, but may be of interest:
#As of Python 3.6+ dictionaries remember the order of items inserted.
#Beware that dictionaries in older versions of Python are unordered.
#https://stackoverflow.com/questions/39980323/are-dictionaries-ordered-in-python-3-6

