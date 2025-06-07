package com.llamasoft.elessa.data

val jsonHomeContainer = """
    {
      "type": "HomeContainer",
      "data": {
        "contentUrl": "https://jsonblob.com/api/1357722897715748864"
      },
      "children": [
        {
          "shimmerId": "TOP_BAR_SHIMMER",
          "type": "TopBarShimmerWidget"
        }
      ],
      "properties": {
        "initActions": [
          {
            "type": "Track",
            "data": {
              "type": "event",
              "path": "Visualización - Home"
            }
          }
        ]
      }
    }
    """.trimIndent()

val jsonHomeContainerData = """
    {
      "type": "home_container",
      "data": {
        "contentUrl": "https://jsonblob.com/api/1357722897715748864"
      },
      "properties": {
        "initActions": []
      },
      "children": []
    }
    """.trimIndent()

val jsonHomeContainerChildren = """
    {
      "type": "HomeContainer",
      "data": {
        "contentUrl": "https://jsonblob.com/api/1357722897715748864"
      },
      "children": [
        {
          "shimmerId": "TOP_BAR_SHIMMER",
          "type": "TopBarShimmerWidget"
        }
      ],
      "properties": {
        "initActions": []
      }
    }
    """.trimIndent()

val jsonHomeContainerActions = """
    {
      "type": "HomeContainer",
      "data": {
        "contentUrl": "https://jsonblob.com/api/1357722897715748864"
      },
      "children": [],
      "properties": {
        "initActions": [
          {
            "type": "Track",
            "data": {
              "type": "event",
              "path": "Visualización - Home"
            }
          }
        ]
      }
    }
    """.trimIndent()
