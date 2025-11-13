import Image from 'next/image';
interface PokemonCardProps {
    topValue: number;
    leftValue: number;
    rightValue: number;
    bottomValue: number;
}
export default function PokemonCard({topValue, leftValue, rightValue, bottomValue}:PokemonCardProps)
{
    return(
        <>
        <div>
            <img
            src="https://storage.googleapis.com/images.pricecharting.com/qpo3i3mlmiezitvq/1600.jpg"
            width={200}
            height={300}
            alt="No image available"
            style={{
                marginTop:topValue +"%"
                }}></img>
        </div>
        </>
    );
}
