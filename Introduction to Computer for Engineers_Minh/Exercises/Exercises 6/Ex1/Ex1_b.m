% Generate a random integer vector with 1,000,000 elements
vector_length = 1000000;
random_vector = randi([-1000, 1000], 1, vector_length);

% Calculate the sum of the squares of the elements using a for loop
sum_of_squares = 0;
for i = 1:length(random_vector)
    sum_of_squares = sum_of_squares + random_vector(i)^2;
end

% Display the sum of the squares
fprintf('Sum of the squares of the elements: %d\n', sum_of_squares);

