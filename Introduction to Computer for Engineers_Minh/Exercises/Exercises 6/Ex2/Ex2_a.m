% Display initial greeting
disp('Hello, what are you saying?');

% Start conversation loop
while true
    % Prompt user for input
    user_input = input('You: ', 's');

    % Break the loop if user enters 'bye'
    if strcmpi(user_input, 'bye')
        disp('Chat Bot: Goodbye!');
        break;
    end

    % Extract the last word from the user input
    words = strsplit(user_input);
    last_word = words{end};

    % Display response
    disp(['Chat Bot: Really, ' last_word '?']);
end

