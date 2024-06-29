function tokenizer()
    % Read text input and separator from the user
    str = input('Enter the text: ', 's');
    sep = input('Enter the separator: ', 's');

    % Split the input text into individual parts based on the separator
    parts = strsplit(str, sep);

    % Initialize variables to store individual words and their vowel counts
    words = cell(1, numel(parts));
    vowel_counts = zeros(1, numel(parts));

    % Iterate over each part
    for i = 1:numel(parts)
        % Store the individual part
        words{i} = parts{i};

        % Count the number of vowels in the individual part
        vowel_counts(i) = countVowels(parts{i});
    end

    % Display the individual words and their vowel counts
    disp('Individual Words | Vowel Counts');
    disp('--------------------------------');
    for i = 1:numel(parts)
        fprintf('%-16s | %d\n', words{i}, vowel_counts(i));
    end
end

function count = countVowels(word)
    % Define vowels
    vowels = 'aeiou';

    % Convert the word to lowercase
    word = lower(word);

    % Count the number of vowels in the word
    count = sum(ismember(word, vowels));
end

