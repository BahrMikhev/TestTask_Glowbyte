brackets = {')' : '(', ']' : '[', '}': '{'}

with open('input.txt') as file:
    s = file.readline()
    stack = list()
    for i in s:
        if i in brackets.values():
            stack.append(i)
        elif stack:
            if brackets[i] == stack[-1]:
                stack.pop()
            else:
                print('FALSE')
                break
        else:
            print('FALSE')
            break
    else:
        if len(stack) == 0:
            print('TRUE')
        else:
            print('FALSE')
