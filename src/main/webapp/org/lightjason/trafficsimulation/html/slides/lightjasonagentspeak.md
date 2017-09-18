<!-- $theme: default -->
<!-- $size: 16:9 -->

<style>
svg.railroad-diagram path {
    stroke-width: 2;
    stroke: grey;
    fill: rgba(0,0,0,0);
}
svg.railroad-diagram text {
    font: bold 14px monospace;
    text-anchor: middle;
}
svg.railroad-diagram rect {
    stroke-width: 3;
    stroke: black;
}

svg.railroad-diagram .non-terminal {
    fill: #14811a;
}
code.remark-inline-code {
    color: #8C1C00;
}
</style>

# LightJason

### Agent-Oriented programming with AgentSpeak(L++)

* Malte Aschermann, Philipp Kraus 
* TU Clausthal
* September 19-20, 2017

<svg xmlns="http://www.w3.org/2000/svg" height="50" viewBox="216 117 225 64"><g fill="none"><path fill="#fff" d="M0 0h513v309H0z"/><circle cx="248.285" cy="149.001" r="28.836" fill="#fff"/><path d="M247.941 117c8.951 0 16.572 3.125 22.857 9.372 3.008 3.009 5.295 6.448 6.857 10.314 1.561 3.867 2.344 7.971 2.344 12.314 0 4.381-.773 8.486-2.314 12.313-1.543 3.828-3.82 7.21-6.828 10.143-3.123 3.085-6.666 5.448-10.629 7.086-3.961 1.638-8.057 2.457-12.285 2.457s-8.276-.808-12.143-2.429c-3.866-1.618-7.333-3.961-10.4-7.027-3.067-3.066-5.4-6.524-7-10.372-1.6-3.848-2.4-7.904-2.4-12.171 0-4.229.809-8.295 2.428-12.2 1.619-3.905 3.972-7.4 7.057-10.486 6.095-6.208 13.58-9.314 22.456-9.314zm.116 5.772c-7.314 0-13.467 2.553-18.458 7.657-2.515 2.553-4.448 5.419-5.8 8.6a25.204 25.204 0 0 0-2.029 9.972c0 3.429.675 6.734 2.029 9.913 1.353 3.183 3.285 6.021 5.8 8.516 2.514 2.496 5.351 4.399 8.515 5.715a25.652 25.652 0 0 0 9.943 1.971c3.428 0 6.75-.665 9.973-1.999 3.219-1.335 6.121-3.257 8.713-5.771 4.99-4.876 7.484-10.99 7.484-18.344 0-3.543-.648-6.895-1.943-10.057-1.293-3.162-3.18-5.98-5.654-8.458-5.146-5.143-11.335-7.715-18.573-7.715zm-.401 20.915l-4.287 2.229c-.458-.951-1.019-1.619-1.685-2-.667-.38-1.286-.571-1.858-.571-2.856 0-4.286 1.885-4.286 5.657 0 1.714.362 3.084 1.085 4.113.724 1.029 1.791 1.544 3.201 1.544 1.867 0 3.181-.915 3.944-2.743l3.942 2c-.838 1.563-2 2.791-3.486 3.686-1.484.896-3.123 1.343-4.914 1.343-2.857 0-5.163-.875-6.915-2.629-1.752-1.752-2.628-4.19-2.628-7.313 0-3.048.886-5.466 2.657-7.257 1.771-1.79 4.009-2.686 6.715-2.686 3.963-.002 6.8 1.541 8.515 4.627zm18.457 0l-4.229 2.229c-.457-.951-1.02-1.619-1.686-2-.668-.38-1.307-.571-1.914-.571-2.857 0-4.287 1.885-4.287 5.657 0 1.714.363 3.084 1.086 4.113.723 1.029 1.789 1.544 3.201 1.544 1.865 0 3.18-.915 3.941-2.743l4 2c-.875 1.563-2.057 2.791-3.541 3.686a9.233 9.233 0 0 1-4.857 1.343c-2.896 0-5.209-.875-6.941-2.629-1.736-1.752-2.602-4.19-2.602-7.313 0-3.048.885-5.466 2.658-7.257 1.77-1.79 4.008-2.686 6.713-2.686 3.962-.002 6.783 1.541 8.458 4.627z" fill="#000"/><circle cx="329.137" cy="149.306" r="28.276" fill="#fff"/><path d="M328.943 117c8.988 0 16.57 3.085 22.742 9.257C357.893 132.467 361 140.048 361 149c0 8.991-3.049 16.476-9.145 22.456-6.476 6.363-14.113 9.544-22.912 9.544-8.649 0-16.153-3.144-22.514-9.43C300.144 165.284 297 157.762 297 149c0-8.761 3.144-16.342 9.429-22.742 6.172-6.173 13.675-9.258 22.514-9.258zm.114 5.772c-7.276 0-13.428 2.553-18.457 7.657-5.22 5.334-7.829 11.525-7.829 18.572 0 7.086 2.59 13.22 7.77 18.398 5.181 5.182 11.352 7.771 18.514 7.771 7.123 0 13.334-2.607 18.629-7.828 5.029-4.838 7.543-10.952 7.543-18.343 0-7.276-2.553-13.465-7.656-18.571-5.104-5.104-11.276-7.656-18.514-7.656zm8.572 18.285v13.085h-3.656v15.542h-9.944v-15.541h-3.656v-13.086c0-.572.2-1.057.599-1.457.401-.399.887-.6 1.457-.6h13.144c.533 0 1.01.2 1.428.6.417.4.628.886.628 1.457zm-13.087-8.228c0-3.008 1.485-4.514 4.458-4.514s4.457 1.504 4.457 4.514c0 2.971-1.486 4.457-4.457 4.457s-4.458-1.486-4.458-4.457z" fill="#000"/><circle cx="408.444" cy="149.131" r="29.105" fill="#fff"/><path d="M408.943 117c8.951 0 16.531 3.105 22.742 9.315C437.893 132.487 441 140.048 441 149c0 8.954-3.049 16.457-9.145 22.514-6.437 6.324-14.076 9.486-22.912 9.486-8.649 0-16.153-3.143-22.514-9.429-6.285-6.285-9.429-13.807-9.429-22.57 0-8.723 3.144-16.285 9.429-22.685 6.209-6.211 13.714-9.316 22.514-9.316zm.114 5.772c-7.276 0-13.428 2.572-18.457 7.715-5.22 5.296-7.829 11.467-7.829 18.513 0 7.125 2.59 13.257 7.77 18.4 5.181 5.182 11.352 7.771 18.514 7.771 7.123 0 13.334-2.609 18.629-7.828 5.029-4.876 7.543-10.99 7.543-18.343 0-7.313-2.553-13.485-7.656-18.513-5.067-5.145-11.239-7.715-18.514-7.715zm-14.286 21.713c.609-3.924 2.189-6.962 4.742-9.114 2.552-2.152 5.656-3.228 9.314-3.228 5.027 0 9.029 1.62 12 4.856 2.971 3.238 4.457 7.391 4.457 12.457 0 4.915-1.543 9-4.627 12.256-3.088 3.256-7.086 4.886-12.002 4.886-3.619 0-6.743-1.085-9.371-3.257-2.629-2.172-4.209-5.257-4.743-9.257h8.059c.19 3.886 2.533 5.829 7.029 5.829 2.246 0 4.057-.972 5.428-2.914 1.373-1.942 2.059-4.534 2.059-7.771 0-3.391-.629-5.971-1.885-7.743-1.258-1.771-3.066-2.657-5.43-2.657-4.268 0-6.667 1.885-7.2 5.656h2.343l-6.342 6.343-6.343-6.343 2.512.001z" fill="#000"/></g></svg>

---
<!-- page_number: true -->
### Lecture Recap I

* [AgentSpeak(L)](https://en.wikipedia.org/wiki/AgentSpeak) \[[Rao 1996](https://link.springer.com/chapter/10.1007/BFb0031845); [Bordini et al. 2007](http://jason.sourceforge.net/jBook/jBook/Home.html)\]

    * [Belief-desire-intention (BDI)](https://en.wikipedia.org/wiki/Belief%E2%80%93desire%E2%80%93intention_model) architecture 
    * [Procedural reasoning system (PRS)](https://en.wikipedia.org/wiki/Procedural_reasoning_system) as execution mechanism 
    * [Logical programming language](https://en.wikipedia.org/wiki/Logic_programming) to represent data with _symbols_ and _facts_
    * Java reference implementation [Jason](http://jason.sourceforge.net/) by Rafael H. Bordini & Jomi F. Hübner

---
### Lecture Recap II

* Based on the work of Rao, Bordini and Hübner, \[[Aschermann and Kraus 2016](https://lightjason.github.io/publication/2016-eumas.pdf)\] designed the agent language AgentSpeak(L++) and [reimplemented it from scratch](https://github.com/AgentSpeak), featuring

    * clean and strict syntax with state-of-the-art technologies
    * [well](https://lightjason.github.io) [documented](http://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/) [software](http://lightjason.github.io/AgentSpeak/sources/) (not just "documentation by research papers")
    * extended PRS with a mechanism optimised for concurrency
    * [REST-API](https://en.wikipedia.org/wiki/Representational_state_transfer) for flexible, system independed control of [multi-agent system (MAS)](https://en.wikipedia.org/wiki/Multi-agent_system)
    * scalable, concurrent execution of up to 2.6 million agents on a desktop computer
    * additional support for cloud computing, for example [Hadoop](https://en.wikipedia.org/wiki/Apache_Hadoop)

* **Important** to distinguish between

    * **AgentSpeak(L++)** as the language to describe agents (knowledge and behaviour) and
    * **LightJason**, the Java implementation to execute agents written in AgentSpeak(L++)

---
### Agent Oriented Programming with AgentSpeak(L++)

#### Agenda

1. [Basic Grammar Elements and Structure](#5)
    * [Atoms](#6)
    * [Terms](#7)
    * [Literals](#8)
    * [Variables](#9)
2. [Giving Life to an Agent](#10)
    * [Plans](#11)
    * [Goals](#12)
    * [Beliefs and Facts](#15)
    * [AgentSpeak(L++) Grammar Structure](#17)
    * [Agent Cycle](#18)
    * [Execution](#19)
    * [Unification](#20)
3. [Additional theory and architecture details](#23)
    * [For Developers (Optional)](#25)
4. [Useful Links](#27)

---
### Basic Grammar Elements and Structure: Symbolic Representation

#### Example: Traffic Light

In imperative programming languages, e.g. Java, traffic light states could be described by:

```java 
String  light = "green";
int     phase_duration = 60;
String  phase_program = "morning";
boolean applies_to_vehicles = true;
boolean applies_to_pedestrians = false;
```

The same information in a _symbolic representation_:

```prolog
light( green ).
phase( duration(60), program(morning) ).
appliesto( vehicles ).
~appliesto( pedestrians ).
```

---
### Atoms

[Atoms](https://lightjason.github.io/knowledgebase/atoms/) are **unsplittable** elements and represent the _basic building blocks_.
Note: They have to be structured in the following form:

<svg height=300px class="railroad-diagram centering" viewBox="0 0 490 229" id="svg_3e10f8c809242d3a0f94c18e7addb866"><path d="M20 30v20m10-20v20M20 40h20.5m-.5 0h10m390 0" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M50 29h140v22H50z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#28e746830337961c5de40b87c99980a6"><text x="120" y="44">LOWERCASELETTER</text></a></g><path d="M190 40h10m0 0a10 10 0 0 0 10-10 10 10 0 0 1 10-10m0 0h200m0 0a10 10 0 0 1 10 10 10 10 0 0 0 10 10m-240 0h20m0 0h10m0 0h20" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M250 29h140v22H250z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#28e746830337961c5de40b87c99980a6"><text x="320" y="44">LOWERCASELETTER</text></a></g><path d="M390 40h20m-180 0a10 10 0 0 1 10 10v10a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M250 59h140v22H250z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#c857e06a9c6dcbcfd625e4859380c98e"><text x="320" y="74">UPPERCASELETTER</text></a></g><path d="M390 70a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m-180 0a10 10 0 0 1 10 10v40a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M250 100h20m100 0h20M270 89h100v22H270z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#a058c5dc734e54ff3d93b96acac339f4"><text x="320" y="104">UNDERSCORE</text></a></g><path d="M390 100a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m-180 0a10 10 0 0 1 10 10v70a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M250 130h40m60 0h40m-100-11h60v22h-60z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#999bbbf1d86bc7611397c77222e076db"><text x="320" y="134">DIGIT</text></a></g><path d="M390 130a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m-180 0a10 10 0 0 1 10 10v100a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M250 160h40m60 0h40m-100-11h60v22h-60z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#646da671ca01bb5d84dbb5fb2238dc8e"><text x="320" y="164">SLASH</text></a></g><path d="M390 160a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m-180 0a10 10 0 0 1 10 10v130a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M250 190h40m60 0h40m-100-11h60v22h-60z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#ffc0d9b54a1fe677c4c9e6b050e67c81"><text x="320" y="194">MINUS</text></a></g><path d="M390 190a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m0 0h10m-190 0a10 10 0 0 0-10 10v149a10 10 0 0 0 10 10m0 0h180m0 0a10 10 0 0 0 10-10V50a10 10 0 0 0-10-10m10 0h20m0 0h10m0 0h20m-10-10v20m10-20v20" transform="translate(.5 .5)"/></svg>

#### Examples

`red`, `green`, `yellow`, `pedestrians`, `vehicle`, `myFirstAtom23`

---
### Terms

[Terms](https://lightjason.github.io/knowledgebase/terms/) can represent **any value- and data-type** within the language.

<svg height=300px class="railroad-diagram centering" viewBox="0 0 580 302" id="svg_b4dad0fe5fbef2c0e24d9db1cc69e5a2"><path d="M20 21v20m10-20v20M20 31h20.5m-.5 0h20" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M60 31h196m68 0h196M256 20h68v22h-68z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#b45cffe084dd3d20d928bee85e7b0f21"><text x="290" y="35">string</text></a></g><path d="M520 31h20M40 31a10 10 0 0 1 10 10v10a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M60 61h196m68 0h196M256 50h68v22h-68z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#b1bc248a7ff2b2e95569f56de68615df"><text x="290" y="65">number</text></a></g><path d="M520 61a10 10 0 0 0 10-10V41a10 10 0 0 1 10-10M40 31a10 10 0 0 1 10 10v40a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M60 91h172m116 0h172M232 80h116v22H232z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#af6a9878b68b9081f2f32558fc1c5f42"><text x="290" y="95">logicalvalue</text></a></g><path d="M520 91a10 10 0 0 0 10-10V41a10 10 0 0 1 10-10M40 31a10 10 0 0 1 10 10v70a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M60 121h192m76 0h192m-268-11h76v22h-76z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#f0d674f1e0ed4292267f149c5983db02"><text x="290" y="125">literal</text></a></g><path d="M520 121a10 10 0 0 0 10-10V41a10 10 0 0 1 10-10M40 31a10 10 0 0 1 10 10v100a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M60 151h188m84 0h188m-272-11h84v22h-84z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#e04aa5104d082e4a51d241391941ba26"><text x="290" y="155">variable</text></a></g><path d="M520 151a10 10 0 0 0 10-10V41a10 10 0 0 1 10-10M40 31a10 10 0 0 1 10 10v130a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M60 181h172m116 0h172m-288-11h116v22H232z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#aa70971153fc735cddfeb6720c3303c9"><text x="290" y="185">variablelist</text></a></g><path d="M520 181a10 10 0 0 0 10-10V41a10 10 0 0 1 10-10M40 31a10 10 0 0 1 10 10v160a10 10 0 0 0 10 10m460 0" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M60 200h164v22H60z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#b11464d4ff702d93244a8e2a7f6ba3bf"><text x="142" y="215">LEFTANGULARBRACKET</text></a></g><path d="M224 211h10m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M244 200h84v22h-84z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#45e9c6711e26d65a3189b502fd08a63"><text x="286" y="215">termlist</text></a></g><path d="M328 211h10m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M348 200h172v22H348z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#a025c9443af11da0298acc93764673e7"><text x="434" y="215">RIGHTANGULARBRACKET</text></a></g><path d="M520 211a10 10 0 0 0 10-10V41a10 10 0 0 1 10-10M40 31a10 10 0 0 1 10 10v190a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M60 241h180m100 0h180m-280-11h100v22H240z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#63973cd3ad7ccf2c8d5dce94b215f683"><text x="290" y="245">expression</text></a></g><path d="M520 241a10 10 0 0 0 10-10V41a10 10 0 0 1 10-10M40 31a10 10 0 0 1 10 10v220a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M60 271h152m156 0h152m-308-11h156v22H212z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#a3e531edbe77ec3a390a2671be0905b8"><text x="290" y="275">ternary_operation</text></a></g><path d="M520 271a10 10 0 0 0 10-10V41a10 10 0 0 1 10-10m0 0h20m-10-10v20m10-20v20" transform="translate(.5 .5)"/></svg>


#### Examples

```prolog
duration(60)
light(red)
```
Here `60` and `red` would be terms.

---
### Literals

[Literals](https://lightjason.github.io/knowledgebase/literals/) are the conclusion of terms and atoms. They have to start with a **lower-case letter**!

<svg class="railroad-diagram centering" viewBox="0 0 872 109" id="svg_f0d674f1e0ed4292267f149c5983db02"><path d="M20 38v20m10-20v20M20 48h20.5m-.5 0h10m0 0a10 10 0 0 0 10-10 10 10 0 0 1 10-10m0 0h172m0 0a10 10 0 0 1 10 10 10 10 0 0 0 10 10M50 48h20m0 0h20" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M90 48h48m36 0h48m-84-11h36v22h-36z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#fa868488740aa25870ced6b9169951fb"><text x="156" y="52">AT</text></a></g><path d="M222 48h20M70 48a10 10 0 0 1 10 10v10a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M90 67h132v22H90z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#207b9b679fb614699f3d949f6fc63218"><text x="156" y="82">STRONGNEGATION</text></a></g><path d="M222 78a10 10 0 0 0 10-10V58a10 10 0 0 1 10-10m0 0h20m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M272 37h52v22h-52z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#3e10f8c809242d3a0f94c18e7addb866"><text x="298" y="52">atom</text></a></g><path d="M324 48h10m0 0a10 10 0 0 0 10-10v-8a10 10 0 0 1 10-10m0 0h448m0 0a10 10 0 0 1 10 10v8a10 10 0 0 0 10 10m-488 0h20m448 0" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M354 37h148v22H354z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#5ffa5d1c78ad09c7bf5b4d0b0764641f"><text x="428" y="52">LEFTROUNDBRACKET</text></a></g><path d="M502 48h10m0 0a10 10 0 0 0 10-10 10 10 0 0 1 10-10m0 0h84m0 0a10 10 0 0 1 10 10 10 10 0 0 0 10 10m-124 0h20" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M532 37h84v22h-84z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#45e9c6711e26d65a3189b502fd08a63"><text x="574" y="52">termlist</text></a></g><path d="M616 48h20m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M646 37h156v22H646z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#3a52152b9f1e9dd45998ce24723d98ed"><text x="724" y="52">RIGHTROUNDBRACKET</text></a></g><path d="M802 48h20m0 0h10m0 0h20m-10-10v20m10-20v20" transform="translate(.5 .5)"/></svg>


#### Example

Combining the terms `phase`, `duration`, `60`, `program` and `morning` into a meaningful literal:
```prolog
phase( duration(60), program(morning) )
```

---
### Variables

[Variables](https://lightjason.github.io/knowledgebase/variables/) are special terms to store data during runtime

<svg height=200px class="railroad-diagram centering" viewBox="0 0 520 199" id="svg_70d97cd67aba0712a4ac127a7307ad12"><path d="M20 30v20m10-20v20M20 40h20.5m-.5 0h10m0 0h20" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M70 29h140v22H70z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#c857e06a9c6dcbcfd625e4859380c98e"><text x="140" y="44">UPPERCASELETTER</text></a></g><path d="M210 40h20M50 40a10 10 0 0 1 10 10v10a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M70 70h20m100 0h20M90 59h100v22H90z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#a058c5dc734e54ff3d93b96acac339f4"><text x="140" y="74">UNDERSCORE</text></a></g><path d="M210 70a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m0 0a10 10 0 0 0 10-10 10 10 0 0 1 10-10m0 0h200m0 0a10 10 0 0 1 10 10 10 10 0 0 0 10 10m-240 0h20m0 0h10m0 0h20" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M280 29h140v22H280z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#28e746830337961c5de40b87c99980a6"><text x="350" y="44">LOWERCASELETTER</text></a></g><path d="M420 40h20m-180 0a10 10 0 0 1 10 10v10a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M280 59h140v22H280z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#c857e06a9c6dcbcfd625e4859380c98e"><text x="350" y="74">UPPERCASELETTER</text></a></g><path d="M420 70a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m-180 0a10 10 0 0 1 10 10v40a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M280 100h20m100 0h20M300 89h100v22H300z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#a058c5dc734e54ff3d93b96acac339f4"><text x="350" y="104">UNDERSCORE</text></a></g><path d="M420 100a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m-180 0a10 10 0 0 1 10 10v70a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M280 130h40m60 0h40m-100-11h60v22h-60z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#999bbbf1d86bc7611397c77222e076db"><text x="350" y="134">DIGIT</text></a></g><path d="M420 130a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m-180 0a10 10 0 0 1 10 10v100a10 10 0 0 0 10 10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M280 160h40m60 0h40m-100-11h60v22h-60z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#646da671ca01bb5d84dbb5fb2238dc8e"><text x="350" y="164">SLASH</text></a></g><path d="M420 160a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m0 0h10m-190 0a10 10 0 0 0-10 10v119a10 10 0 0 0 10 10m0 0h180m0 0a10 10 0 0 0 10-10V50a10 10 0 0 0-10-10m10 0h20m0 0h10m0 0h20m-10-10v20m10-20v20" transform="translate(.5 .5)"/></svg>

There are two kinds of variables
* Regular variables start with an **upper-case** letter
* The _garbage bin_ variable `_` can be used as a substitute in cases where the content of the variable is not of interest, but a variable has to be provided.

#### Example

```prolog
NewDuration = 90
```

---
### Giving Life to an Agent - Events, Plans and Goals

[Plans](https://lightjason.github.io/knowledgebase/plansandrules/) are like _static methods_ or _functions_ in an imperative programming language, with an execution condition and boolean return value.

* For example, consider the following Java method to change the phase duration of a traffic light:
  ```java
  public static boolean phaseduration( int newduration )
  {
      if ( newduration < 1 )   // Plan condition: plan fails if
          return false;        // new duration is unreasonably small
        
      System.out.println( "For safety, changing light to RED" );
      System.out.println( "Changing phase duration to " + newduration );
      return true;             // Plan succeeded
  }
  ```

---
### Plans

<svg width=800px class="railroad-diagram" viewBox="0 0 726 80" id="svg_5fc25157650d0cb24f02216d904584df"><path d="M20 30v20m10-20v20M20 40h20.5m-.5 0h10m0 0a10 10 0 0 0 10-10 10 10 0 0 1 10-10m0 0h108m0 0a10 10 0 0 1 10 10 10 10 0 0 0 10 10M50 40h20" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M70 29h108v22H70z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#4ab6864fc58ecd8b598ee10dfe2ac311"><text x="124" y="44">annotations</text></a></g><path d="M178 40h20m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M208 29h116v22H208z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#4f0fa1b5875427a602b3f913163be2ca"><text x="266" y="44">plan_trigger</text></a></g><path d="M324 40h10m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M344 29h76v22h-76z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#f0d674f1e0ed4292267f149c5983db02"><text x="382" y="44">literal</text></a></g><path d="M420 40h10m0 0a10 10 0 0 0 10-10 10 10 0 0 1 10-10m0 0h152m0 0a10 10 0 0 1 10 10 10 10 0 0 0 10 10m-192 0h20m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M460 29h132v22H460z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#d60b4a42e52668da3017e5717ef3f60"><text x="526" y="44">plandefinition</text></a></g><path d="M592 40h10m-142 0a10 10 0 0 0-10 10 10 10 0 0 0 10 10m0 0h132m0 0a10 10 0 0 0 10-10 10 10 0 0 0-10-10m10 0h20m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M632 29h44v22h-44z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#40679521b5da0954b705341a2859f782"><text x="654" y="44">DOT</text></a></g><path d="M676 40h10m0 0h20m-10-10v20m10-20v20" transform="translate(.5 .5)"/></svg>

To transform the imperative method to a logical plan, proceed as follows:

* Consider every execution path! For the method `phaseduration` this would be
  1. If the phase duration is less than one second, the plan always fails (&#8594; early exit).
  2. If the phase duration is equal to or greater than one second, set the traffic light to `red` and the phase duration to the value of variable `newduration`.
* Variables have to start with a capital letter, e.g. `newduration` &#8658; `NewDuration`.
* Statements have to be separated by a semicolon `;`, except the last one!
* A plan has to be terminated by a full stop symbol `.`

```prolog
+!phaseduration(NewDuration)
    : NewDuration < 1 <-    // path 1: plan condition to always fail
        fail                // fail simply marks the plan as failed.

    : NewDuration >= 1 <-   // path 2: plan condition to change light and succeed
        generic/print( "For safety, changing light to RED" );
        generic/print( "Changing phase duration to", NewDuration )
.
```

---
### Goals

<svg class="railroad-diagram" width="524" height="92" viewBox="0 0 524 92"><path d="M20.5 21.5v20m10-20v20m-10-10H41M40.5 31.5h10M50.5 31.5h20"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M70 31h24M234 31h24M94 20h140v22H94z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#a811f517fa7f9ba04cf05d3a6c777799"><text x="164" y="35">EXCLAMATIONMARK</text></a></g><path d="M258.5 31.5h20M50.5 31.5a10 10 0 0 1 10 10v10a10 10 0 0 0 10 10"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M70 50h188v22H70z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#54d93a03ab9f9e3d0cdcbe9e3ce017be"><text x="164" y="65">DOUBLEEXCLAMATIONMARK</text></a></g><path d="M258.5 61.5a10 10 0 0 0 10-10v-10a10 10 0 0 1 10-10"/><g><path d="M278.5 31.5h20"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M298 31h40M414 31h40M338 20h76v22h-76z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#f0d674f1e0ed4292267f149c5983db02"><text x="376" y="35">literal</text></a></g><path d="M454.5 31.5h20M278.5 31.5a10 10 0 0 1 10 10v10a10 10 0 0 0 10 10"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M298 50h156v22H298z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#a8a6a0dad629d3c681de3e882cbc44a9"><text x="376" y="65">variable_evaluate</text></a></g><path d="M454.5 61.5a10 10 0 0 0 10-10v-10a10 10 0 0 1 10-10"/></g><path d="M474.5 31.5h10M484.5 31.5h20m-10-10v20m10-20v20"/></svg>

* [Goals](https://lightjason.github.io/knowledgebase/goals/) define which plans an agent should try to instantiate and execute.
* They can be defined as 
    * [the initial goal](http://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#12a3e79ad1f2c67d5cd687d1277a51b1), i.e. by convention `!main.` or 
    * [achievement goals inside plans](http://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#a6ff3b47279b01ca106287f45227661c), e.g. `!phaseduration(90)`, which means _"try to instantiate and execute a plan `phaseduration(NewDuration)` (with parameter variable `NewDuration` set to `90`) in the next cycle"_.
  
  (&#8594; see example on the next slide)

---
### Goals - Example

```prolog
!main.

+!main <-
    generic/print("Hello World!");
    !phaseduration(90)    // add a goal to be executed in the next cycle
.

+!phaseduration(NewDuration)
    : NewDuration < 1 <-
        fail
 
    : NewDuration >= 1 <-
        generic/print( "For safety, changing light to RED" );
        generic/print( "Changing phase duration to", NewDuration )
.
```

---
### Goals - Advanced Triggering: ! vs. !!

Execution order of plans differs depending on used trigger symbol `!` or `!!`:
* The trigger `!planname` marks a plan `+!planname` to be executed in the next cycle.
  * **Note:** Adding `!planname` multiple times in one cycle will result in `+!planname` to be executed only **once** in the next cycle because the same trigger gets only added once.
* `!!planname` executes the matching plan immediately.
  * **Note:** As every plan body is executed sequentially, for each given `!!planname` the plan `+!planname` will be executed in that sequence.
* If the plan contains a variable, e.g. `+!plan(N)`, multiple different triggers are possible (e.g. `!plan(5)` and `!plan(23)` differ). Each individual trigger will be queued for execution in the next cycle.
  
For example consider the plan `+!phaseduration(NewDuration)`.
A plan body containing

```prolog
!phaseduration(90); !phaseduration(60)
```

will result in two plans for `90` and `60` to be run in *parallel* in the next cycle, whereas

```prolog
!!phaseduration(90); !!phaseduration(60)
```

will execute the two plans immediately in the given order, i.e. `+!phaseduration(90)` &#8594; `+!phaseduration(60)`.

For more details and examples see [Plan Triggering Techniques](https://lightjason.github.io/knowledgebase/triggering/) in our knowledge base.

---
### Beliefs and Facts

<svg class="railroad-diagram" width="286" height="92" viewBox="0 0 286 92"><path d="M20.5 21.5v20m10-20v20m-10-10H41M40.5 31.5h10M50.5 31.5h20"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M70 31h4M126 31h4M74 20h52v22H74z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#883acd43c77567e1c3baced84ccf6ed7"><text x="100" y="35">PLUS</text></a></g><path d="M130.5 31.5h20M50.5 31.5a10 10 0 0 1 10 10v10a10 10 0 0 0 10 10"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M70 50h60v22H70z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#ffc0d9b54a1fe677c4c9e6b050e67c81"><text x="100" y="65">MINUS</text></a></g><path d="M130.5 61.5a10 10 0 0 0 10-10v-10a10 10 0 0 1 10-10M150.5 31.5h10"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M160 20h76v22h-76z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#f0d674f1e0ed4292267f149c5983db02"><text x="198" y="35">literal</text></a></g><path d="M236.5 31.5h10M246.5 31.5h20m-10-10v20m10-20v20"/></svg>

Any literal can be a [belief or fact](https://lightjason.github.io/knowledgebase/beliefsandfacts/):

* Any information can be stored as a belief or fact (the distinction depends on the used context).
* Both are denoted as literals.
* A belief can be generated by
    * sensors the agent uses to perceive its environment.
    * agents themselves, so the agent can _conclude_ new beliefs by combining existing ones
* Initial beliefs are defined at the beginning of the `.asl` and terminated via `.`, e.g. `light(red).`.

**Note:** Perceptions might be wrong!
For instance, a sensor can be defect, or other agents may simply "lie" (depending on the scenario).
So a .important[belief can be perceived or considered as true, but need not to be factually true].

#### Examples

```prolog
-light(red)                               // removes belief
+light(green)                             // adds belief
+phase( duration(60), program(morning) )  // adds belief
```

---
### Beliefs - Extending The Traffic Light Example

```prolog
light(red).
phase( duration(60), program(morning) ).

!main.

+!main <-
    generic/print("Hello World!");
    -light(red); +light(green);
    !phaseduration(90)
.

+!phaseduration(NewDuration)
    : NewDuration < 1 <-
        fail

    : NewDuration >= 1 <-
        generic/print( "For safety, changing light to RED" );
        -light(green); +light(red);
        generic/print( "Changing phase duration to", NewDuration );
        -phase( duration(CurrentDuration), program(Program) );
        +phase( duration(NewDuration), program(Program) )
.
```

**Exercise to the reader:** What could possibly go wrong?
(Hint: Have a look at the plan `+!phaseduration(NewDuration)` and the belief `light`)

<!--
Possible answer: +!phaseduration(NewDuration) assumes that the light is currently green.
If run twice or with different initial belief light, this will lead to unintended behaviour.
=> We will handle that in section "Unification".
-->

---
### Summary: AgentSpeak(L++) Grammar Structure

* Concluding from the previous slides, AgentSpeak(L++) structures the knowledge and behaviour of agents like an onion:
  
  ![image](slides/lightjasonagentspeak/grammar.png)

* Simple **Terminal Symbols** contain language keywords and *basic building blocks*
  * e.g. `:`, `<-`, `+`, `-`, `!`, `!!`, `;`, `(`, `)`, `.`

* **Complex Types** extend Terminal Symbols to literals and logical language elements.
  * e.g. `light( red ).`

* The language allows agent behaviour to be expressed by means of plans.
  * e.g. `+!phaseduration(NewDuration)`

* Agents comprise all these levels of language elements.

---
### Agent Cycle

* Agents are repeatedly executed by a [runtime](https://lightjason.github.io/knowledgebase/logicalprogramming/#runtime) of the simulation.

* Each time an agent is executed it runs through the [_agent cycle_](https://lightjason.github.io/knowledgebase/differencetojason/#lightjason-agent-cycle):
  1. updating beliefs by perceiving the environment with sensors
  2. executes all possible, i.e. _instantiable_ plans in parallel

**Note**: Each step is executed in parallel, which means that data perception from sensors, agent and plan execution are also done in parallel.

---
### Execution - Finite-State Machine

[Finite-state machines (FSM)](https://lightjason.github.io/knowledgebase/finitestatemachine) can be used to illustrate the execution of agents.
* The **initial state** is equivalent to the initial goal
* A **state** is the agent's knowledge, i.e. the set of beliefs after the execution phase in the agent cycle finished.
* A **transition** is the execution of a plan (with instantiation of a goal), limited by the plan condition.

#### Example

```prolog
!main.
+!main <- !first; !second.
+!first <- !first.
+!second <- !main.
```

<svg height=230px id="agentfsm" xmlns="http://www.w3.org/2000/svg" viewBox="71 51 490 248"><defs><style>@keyframes colorchange{0%{fill:#fff}50%{fill:#0e7}100%{fill:#fff}}tspan{font-family:sans-serif;fill:#000}</style><marker orient="auto" overflow="visible" id="a" viewBox="-1 -4 10 8" markerWidth="10" markerHeight="8" color="#000"><path d="M8 0L0-3v6z" fill="currentColor" stroke="currentColor"></path></marker><marker orient="auto" overflow="visible" id="b" viewBox="-9 -4 10 8" markerWidth="10" markerHeight="8" color="#000"><path d="M-8 0l8 3v-6z" fill="currentColor" stroke="currentColor"></path></marker></defs><g fill="none"><circle class="state" cx="130.5" cy="121.5" r="22.5"></circle><circle id="init" cx="130.5" cy="121.5" r="22.5" stroke="#000" stroke-linecap="round" stroke-linejoin="round"></circle><path d="M82.5 109.5l25.5 12.75L82.5 135z" fill="#fff"></path><path d="M82.5 109.5l25.5 12.75L82.5 135z" stroke="#000" stroke-linecap="round" stroke-linejoin="round"></path><circle class="state" cx="292.5" cy="121.5" r="22.5"></circle><circle id="main" cx="292.5" cy="121.5" r="22.5" stroke="#000" stroke-linecap="round" stroke-linejoin="round"></circle><circle class="state" cx="434.376" cy="121.5" r="22.5"></circle><circle id="first" cx="434.376" cy="121.5" r="22.5" stroke="#000" stroke-linecap="round" stroke-linejoin="round"></circle><circle class="state" cx="355.5" cy="265.5" r="22.5"></circle><circle id="second" cx="355.5" cy="265.5" r="22.5" stroke="#000" stroke-linecap="round" stroke-linejoin="round"></circle><path marker-end="url(#a)" stroke="#000" stroke-linecap="round" stroke-linejoin="round" d="M153 121.5h107.1m54.9 0h86.976m-89.208 9.784c15.854 9.18 36.886 25.068 47.232 48.716 8.308 18.99 7.907 38.826 5.104 54.606"></path><path d="M282.896 152.394c-2.803 15.78-3.204 35.617 5.104 54.606 10.346 23.648 31.378 39.537 47.232 48.716" marker-start="url(#b)" stroke="#000" stroke-linecap="round" stroke-linejoin="round"></path><path d="M448.939 104.346C464.217 87.377 488.17 63.813 504 63c24.824-1.275 37.725 37.427 18 54-10.586 8.895-35.047 9.538-55.441 8.225" marker-end="url(#a)" stroke="#000" stroke-linecap="round" stroke-linejoin="round"></path><path fill="#fff" d="M177.515 106.5h49v30h-49z"></path><text transform="translate(182.515 112.276)"><tspan x=".084" y="15" textLength="38.832">!main</tspan></text><path fill="#fff" d="M338.2 106.5h41v30h-41z"></path><text transform="translate(343.2 112.276)"><tspan x=".1" y="15" textLength="30.8">!first</tspan></text><path fill="#fff" d="M510.291 72.278h41v30h-41z"></path><text transform="translate(515.291 78.054)"><tspan x=".1" y="15" textLength="30.8">!first</tspan></text><path fill="#fff" d="M317.016 148.745h67v30h-67z"></path><text transform="translate(322.016 154.521)"><tspan x=".052" y="15" textLength="56.896">!second</tspan></text><path fill="#fff" d="M266.617 198.336h49v30h-49z"></path><text transform="translate(271.617 204.112)"><tspan x=".084" y="15" textLength="38.832">!main</tspan></text></g></svg>

---
### Unification

<svg width=1000px class="railroad-diagram" viewBox="0 0 1052 101" id="svg_e732ce4bb8479dc479e294d62beaf1cf"><path d="M20 30v20m10-20v20M20 40h20.5m-.5 0h10m0 0a10 10 0 0 0 10-10 10 10 0 0 1 10-10m0 0h36m0 0a10 10 0 0 1 10 10 10 10 0 0 0 10 10m-76 0h20" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M70 29h36v22H70z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#fa868488740aa25870ced6b9169951fb"><text x="88" y="44">AT</text></a></g><path d="M106 40h20m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M136 29h100v22H136z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#f2160f407f56e0f4d495cecd44055e2d"><text x="186" y="44">RIGHTSHIFT</text></a></g><path d="M236 40h10m0 0h20" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M266 40h320m76 0h320M586 29h76v22h-76z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#f0d674f1e0ed4292267f149c5983db02"><text x="624" y="44">literal</text></a></g><path d="M982 40h20m-756 0a10 10 0 0 1 10 10v10a10 10 0 0 0 10 10m716 0" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M266 59h148v22H266z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#5ffa5d1c78ad09c7bf5b4d0b0764641f"><text x="340" y="74">LEFTROUNDBRACKET</text></a></g><path d="M414 70h10m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M434 59h76v22h-76z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#f0d674f1e0ed4292267f149c5983db02"><text x="472" y="74">literal</text></a></g><path d="M510 70h10m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M530 59h60v22h-60z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#4d9b3e9fc12849d060371eb65154c751"><text x="560" y="74">COMMA</text></a></g><path d="M590 70h10m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M610 59h196v22H610z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#89368367b9f48fd82a781f5a4e1ad8b6"><text x="708" y="74">unification_constraint</text></a></g><path d="M806 70h10m0 0h10" transform="translate(.5 .5)"/><g class="non-terminal" transform="translate(.5 .5)"><path d="M826 59h156v22H826z"/><a xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="https://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/index.htm#3a52152b9f1e9dd45998ce24723d98ed"><text x="904" y="74">RIGHTROUNDBRACKET</text></a></g><path d="M982 70a10 10 0 0 0 10-10V50a10 10 0 0 1 10-10m0 0h10m0 0h20m-10-10v20m10-20v20" transform="translate(.5 .5)"/></svg>

* [Unification](https://lightjason.github.io/knowledgebase/unification/) is the process for setting values from one literal to the variables of another literal, e.g. determining the current value of `Colour` in `light(Colour)`?
  Note: `Colour` is a variable!

* [Remember the issue](#16) we had with the plan `+!phaseduration(NewDuration)` and the traffic light state?
  * It can easily be fixed with _unification_ to get the current state and act accordingly:

    Based on the initial beliefs of the previous example

    ```prolog
    >>phase( duration(CurrentDuration), program(Program) ) && >>light(Colour)
    ```

    unifies `CurrentDuration`, `Program` and `Colour` to `60`, `morning` and `red` respectively.

---
### Unification - Extending The Traffic Light Example

```prolog
light(red).
phase( duration(60), program(morning) ).

!main.

+!main <-
    generic/print("Hello World!");
    -light(red); +light(green);
    !phaseduration(90)
.

+!phaseduration(NewDuration)
    : NewDuration < 1 <-
        fail

    : NewDuration >= 1 && >>light(Colour) &&
      >>phase( duration(CurrentDuration), program(Program) ) <-
        generic/print( "For safety, changing light", Colour, "to RED" );
        -light(Colour);
        +light(red);
        generic/print( "Changing phase duration to", NewDuration );
        -phase( duration(CurrentDuration), program(Program) );
        +phase( duration(NewDuration), program(Program) )
.
```

---
### Unification - Exercise

**Exercise to the reader:** 

* Write a plan `+!changelight` which changes the traffic light to the next logical state (depending on the current), i.e. `light(red)` &#8594; `light(redyellow)` &#8594; `light(green)` &#8594; `light(yellow)` &#8594; `light(red)` &#8594; ... each time the plan gets triggered.
* Hints:
  * Encode all possible states in an initial belief.
  * You will have to trigger the plan **sequentially** (a traffic light would not switch states in parallel, would it?). So you should use `!!changelight` in the `+!main` plan.
  * Start with the following code excerpt:

  ```prolog
  states( red, redyellow, yellow, green ).  // initial definition of states
  light( red ).                             // initial traffic light state
  !main.

  +!main <-
      >>light( Colour );
      generic/print( "initial state", Colour );
      !!changelight;   // use !! to sequentially trigger changelight in THIS agent cycle
      // ...
      !!changelight
  .
  ```

<!-- possible solution
+!changelight
  : >>light( Colour ) && >>states( Red, RedYellow, Yellow, Green ) && Colour == Red
  <- generic/print( "changing light: red -> redyellow");
     -light( Colour );
     +light( RedYellow )

  : >>light( Colour) && >>states( Red, RedYellow, Yellow, Green ) && Colour == RedYellow
  <- generic/print( "changing light: redyellow -> green" );
     -light( Colour );
     +light( Green )

  : >>light( Colour) && >>states( Red, RedYellow, Yellow, Green ) && Colour == Green
  <- generic/print( "changing light: green -> yellow" );
     -light( Colour );
     +light( Yellow )

  : >>light(Colour) && >>states( Red, RedYellow, Yellow, Green ) && Colour == Yellow
  <- generic/print( "changing light: yellow -> red" );
     -light( Colour );
     +light( Red )
.
-->

---
### For Developers (Optional) - LightJason Architecture

![image](slides/lightjasonagentspeak/agenthouse.png#floatright)

From a developer's perspective, LightJason combines aspects of

* functional 
* object-oriented and
* logic

programming to the concept of *agent-oriented programming (AOP)*.

For developing a multi-agent system, object-oriented parts (Java) and *functional behaviour of the simulated elements* are needed.

In LightJason, this behaviour is written in AgentSpeak(L++).


---
### For Developers (Optional) - Two-Layer Agent

![image](slides/lightjasonagentspeak/twolayeragent.png#floatright)

Our agent design reflects the concepts of the LightJason architecture:

The
* *body* is the **Java part** of the simulation element.
* *mind* is the **AgentSpeak(L++) script**.
* *body* passes all information and perceived data to the mind.
* *mind* will be executed with the information provided by the body and passes information back to the body.

From the developer perspective,  
  * the *mind* of an agent should be implemented with a **domain-dependent behaviour model**, e.g. the driving behaviour of the vehicle; 
  * the *body* should be implemented with a **domain independent execution model** within the simulation software.

---
### Useful Links

* [Source code](https://github.com/LightJason/Examples/tree/workshop-trafficsimulation) and [executable jar](https://github.com/LightJason/Examples/tree/jar-workshop-trafficsimulation) of this workshop

* LightJason [project site](http://lightjason.org)

* A complete list of syntax elements of AgentSpeak(L++) can be found in the [agent syntax diagram](http://lightjason.github.io/AgentSpeak/rrd-output/html/org/lightjason/agentspeak/grammar/Agent.g4/)

* For developers interested in LightJason/AgentSpeak(L++), we provide a
  * set of [tutorials](https://lightjason.github.io/tutorials/) with [source code](https://github.com/LightJason/Examples) to understand the practical applications of our framework,
  * [knowledge base](https://lightjason.github.io/knowledgebase/) for the theoretical aspects,
  * [wizard](https://lightjason.github.io/tutorials/wizard/) to create a LightJason project package for multi-agent simulations,
  * [GitHub repository](https://github.com/LightJason/AgentSpeak) and
  * [project](http://lightjason.github.io/AgentSpeak/) and [source code](http://lightjason.github.io/AgentSpeak/sources/) documentation.
