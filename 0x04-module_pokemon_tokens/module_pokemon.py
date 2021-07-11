#!/usr/bin/python3
"""
This is the "module_pokemon" module.
the module_pokemon provides four functions,
lista_clases(), laminas_faltantes_por_clase(),
laminas_faltantes(), cantidad_laminas_cambiables()
"""


def lista_clases(classes):
    """Given a list of the classes of all Fernando's Pokémon sheets.

    Args:
        classes (list): The first parameter.


    Returns:
        list:  a list of the classes of sheets found in Fernando's list,
               in strict order in which the classes are detected
               if they are read from the first to the last..
    """
    found_classes = []
    for item in classes:
        if item not in found_classes:
            found_classes.append(item)

    return found_classes


def laminas_faltantes_por_clase(indices, clases, class_to_verify):
    """Given the list of the classes of the laminas available
       to change that a friend has, Fernando quickly reviews it and creates
       a list of the indexes (the count starts from 0) of the laminas
       that he does not have from that list..

    Args:
        indices (list): The first parameter
        classes (list): The second parmeter.
        class_to_verify (): the third parameter.

    Returns:
        list:  a list with the indexes of the sheets of that particular class
               that Fernando is missing
    """
    pass


def laminas_faltantes(personal_cards1, personal_cards2):
    """Given a list with the sheets that a friend has and the list with
       the sheets that Fernando has.

    Args:
        personal_cards1 (list): The first parameter.
        personal_cards2 (list): The second parameter.

    Returns:
        list: the list with the sheets that Fernando would be interested
        in exchanging from his friend's list.
    """
    return [item for item in personal_cards1 if item not in personal_cards2]


def cantidad_laminas_cambiables(laminas_persona1, laminas_persona2):
    """Given the list of sheets that a friend has and the list of sheets
      that Fernando has, the function must return the number of sheets
      that they can change..

      The list that each person manages indicates the numbers of the sheets
      they have to change and those numbers that are not in the list are the
      ones they need.

    Args:
        personal_cards1 (list): The first parameter.
        personal_cards2 (list): The second parameter.

    Returns:
        int:  the number of sheets that they can change.

    """
    return len(laminas_persona2) - len(set(laminas_persona1) & set(laminas_persona2))
