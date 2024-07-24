def input_int(low, high, prompt):
    error = f"Language number must be between {low} and {high} inclusive"  # TODO: Refactor

    out = prompt
    user_input = None
    while True:
        try:
            user_input = int(input(out))
            if user_input < low or user_input > high:
                print(error)
            else:
                break
        except ValueError:
            print(error)
            
    return user_input

def input_string(prompt):
    return str(input(prompt))
