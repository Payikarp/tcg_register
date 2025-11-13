'use client'
import Image from "next/image";
import "@/app/css/homeStyles.css";
import PokemonCard from "@/app/components/cards/pokemonCard";
import {randomPosition} from "@/app/scripts/homepage-script";
import { useState, useEffect } from "react";

export default function Home() {
  const [locationData, setLocationData] = useState<number[]>([]);
  useEffect(() => {
    let positions =  [];
    positions = randomPosition();
    setLocationData(positions);
  }, []);
  
  return (
    <html>
      <body>
        <div id="container">
          <div id="titleDiv">
            <p className="titleClass">TCG Register</p>
            <Image id="enterButton"
            src="/images/enterButton.png"
            width={100}
            height={100}
            alt="Enter">
            </Image>
          </div>
            <div id="backgroundDiv">
              <PokemonCard
              topValue = {locationData[0]}>
            </PokemonCard>
            <PokemonCard
              topValue = {locationData[1]}>
            </PokemonCard>
            </div>
        </div>
    </body>
    </html>
  );
}
