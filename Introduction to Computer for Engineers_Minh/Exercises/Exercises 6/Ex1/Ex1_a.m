% Prompt the user to input the value of T
T = input('Enter the value of T: ');

% Calculate h(T) based on the conditions
if T > 0
    h = T - 10;
elseif T >= 100
    h = 0.45*T + 900;
else
    % Print "Invalid" and stop script
    fprintf('Invalid\n');
    return;
end

% Display the result
fprintf('h(%d) = %d\n', T, h);

