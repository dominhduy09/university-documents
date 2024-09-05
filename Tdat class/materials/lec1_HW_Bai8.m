clear all;
close all;

k = 1;
while (true)
    if (2 ^ k > 2000)
        fprintf('At this value the series exceed 2000: k = %d',k);
        break;
    end
    k = k + 1;
end