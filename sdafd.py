

def compare(s, t):
    if s == t:
        print('Same')
    elif s.upper() == t.upper():
        print('Case different')
    else:
        print('No match')
compare('atcg','aggg')
