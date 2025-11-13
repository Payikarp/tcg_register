
export function randomPosition()
{
    var firsttopValue = Math.floor(Math.random() * (80 - 5) + 5);
    var secondtopValue = Math.floor(Math.random() * (80 - 5) + 5);
    let position = [firsttopValue, secondtopValue];
    return position;

    /**
     * 1=15
     * 2=13
     */
}