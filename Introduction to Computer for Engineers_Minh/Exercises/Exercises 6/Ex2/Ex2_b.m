% Example string
example_string = 'an hours sitting with a lazy dog and with the flowers';

% Convert the string to lowercase
example_string = lower(example_string);

% Split the string into words
words = regexp(example_string, '\w+', 'match');

% Define articles to be excluded
articles = {'a', 'an', 'the'};

% Initialize word count
word_count = 0;

% Count words excluding articles
for i = 1:length(words)
    if ~ismember(words{i}, articles)
        word_count = word_count + 1;
    end
end

% Display the word count
fprintf('Number of words excluding articles: %d\n', word_count);

